package ebisus.monkagiga.kamicompapp.android.ui.combined

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ebisus.monkagiga.kamicompapp.core.domain.repository.EidolonRepository
import ebisus.monkagiga.kamicompapp.core.domain.repository.KamihimeRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CombinedListViewModel @Inject constructor(
    private val kamihimeRepository: KamihimeRepository,
    private val eidolonRepository: EidolonRepository,
    private val filterTagHelper: FilterTagHelper
) : ViewModel() {

    private val _uiState = MutableStateFlow<State?>(null)
    val uiState: Flow<State> = _uiState.filterNotNull()

    private val eventChannel = Channel<Event>(Channel.CONFLATED)
    val eventsFlow = eventChannel.receiveAsFlow()

    init {
        createItems()
    }

    private fun createItems() = viewModelScope.launch {
        val kamihimeList = kamihimeRepository.getKamihimeDetailsList()
        val eidolonList = eidolonRepository.getEidolonList()
        val soulList = emptyList<Any>() // TODO
        val kamihimeListItems = kamihimeList.map {
            CombinedListItem.CombinedListKamihimeItem(
                kamihimeDetails = it
            )
        }
        val eidolonListItems = eidolonList.map {
            CombinedListItem.CombinedListEidolonItem(
                eidolon = it
            )
        }
        val kamihimeListItemsWithTags = kamihimeListItems.map {
            val tags = filterTagHelper.getTagsFromKamihime(it.kamihimeDetails)
            tags.map { tag -> tag to it }
        }
            .flatten()
            .groupBy { it.first }
            .map {
                it.key to it.value.map { it.second }
            }
            .toMap()

        val eidolonListItemsWithTags = eidolonListItems.map {
            val tags = filterTagHelper.getTagsFromEidolon(it.eidolon)
            tags.map { tag -> tag to it }
        }
            .flatten()
            .groupBy { it.first }
            .map {
                it.key to it.value.map { it.second }
            }
            .toMap()

        val filterMap = (kamihimeListItemsWithTags.asSequence() + eidolonListItemsWithTags.asSequence())
            .distinct()
            .groupBy({ it.key }, { it.value })
            .mapValues { (_, values) -> values.flatten() }

        val availableKeys = filterMap.keys
        val filterItems = availableKeys.groupBy { it.category }
            .map {
                CombinedListItem.CombinedListFiltersItem(
                    filterTagCategory = it.key,
                    filters = it.value,
                    enabledFilters = emptyList()
                )
            }

        val filters = FilterTag.values().groupBy { it.category }

        val items = kamihimeListItems + eidolonListItems

        _uiState.emit(
            State(
                filterItems = filterItems,
                items = items,
                filters = filters,
                filterMap = filterMap,
                enabledFilters = filters.map { it.key to emptyList<FilterTag>() }.toMap(),
                filteredItems = emptyList()
            )
        )

        filterItems()
    }

    private suspend fun filterItems() {
        val state = _uiState.value ?: return
        if (state.enabledFilters.all { it.value.isEmpty() }) {
            _uiState.emit(
                state.copy(
                    filteredItems = state.items
                )
            )
            return
        }
        val filteredItems = state.items.filter { listItem ->

            state.enabledFilters.all {
                if(it.value.isEmpty()) {
                    true
                } else it.value.any {
                    state.filterMap[it]?.contains(listItem) == true
                }
            }
        }
        _uiState.emit(
            state.copy(
                filteredItems = filteredItems
            )
        )
    }

    fun onKamihimeClicked(item: CombinedListItem.CombinedListKamihimeItem) = viewModelScope.launch {
        eventChannel.send(Event.NavigateToKamihimeDetails(item.kamihimeDetails.kamihime.id))
    }

    fun onEidolonClicked() = viewModelScope.launch {
    }

    fun onSoulClicked() = viewModelScope.launch {
    }

    fun onFiltersChanged(filterTagCategory: FilterTagCategory, filters: List<FilterTag>) = viewModelScope.launch {
        val state = _uiState.value ?: return@launch
        val newFilterMap = state.enabledFilters.map {
            if(it.key != filterTagCategory) {
                it.key to it.value
            } else {
                it.key to filters
            }
        }.toMap()
        _uiState.emit(
            state.copy(
                enabledFilters = newFilterMap,
            )
        )
        filterItems()
    }

    data class State(
        val filterItems: List<CombinedListItem.CombinedListFiltersItem>,
        val items: List<CombinedListItem>,
        val filteredItems: List<CombinedListItem>,
        val filterMap: Map<FilterTag, List<CombinedListItem>>,
        val filters: Map<FilterTagCategory, List<FilterTag>>,
        val enabledFilters: Map<FilterTagCategory, List<FilterTag>>
    )

    sealed class Event {
        data class NavigateToKamihimeDetails(val id: Long) : Event()
    }
}
