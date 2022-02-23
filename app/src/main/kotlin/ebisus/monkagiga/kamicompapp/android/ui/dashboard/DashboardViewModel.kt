package ebisus.monkagiga.kamicompapp.android.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.core.domain.ImageResourceProvider
import ebisus.monkagiga.kamicompapp.core.domain.repository.KamihimeRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val kamihimeRepository: KamihimeRepository,
    private var imageResourceProvider: ImageResourceProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<State?>(null)
    val uiState: Flow<State> = _uiState.filterNotNull()

    private val eventChannel = Channel<Event>(Channel.CONFLATED)
    val eventsFlow = eventChannel.receiveAsFlow()

    init {
        initState()
    }

    private fun initState() = viewModelScope.launch {
        _uiState.emit(
            State(
                items = listOf(
                    DashboardItem(
                        dashboardItemType = DashboardItemType.KAMIHIME,
                        imageUrlGenerator = { imageResourceProvider.getPath("illust-com-kneeshot", "chara", (5001..5200).random(), 0, "png", false) },
                        text = R.string.kamihime,
                    ),
                    DashboardItem(
                        dashboardItemType = DashboardItemType.SOUL,
                        imageUrlGenerator = { imageResourceProvider.getPath("illust-com-kneeshot", "job", (1..40).random(), 0, "png", false) },
                        text = R.string.souls,
                    ),
                    DashboardItem(
                        dashboardItemType = DashboardItemType.EIDOLONS,
                        imageUrlGenerator = { imageResourceProvider.getPath("illust-com-kneeshot", "summon", (5001..5040).random(), 0, "png", false) },
                        text = R.string.eidolons,
                    ),
                    DashboardItem(
                        dashboardItemType = DashboardItemType.WEAPONS,
                        imageUrlGenerator = {
                            val id = (listOf(1..20, 411..422, 431..439, 441..458, 1001..1060, 2001..2210, 2501..2752, 7001..7003).random()).random()
                            imageResourceProvider.getPath("illustzoom", "weapon", id, 0, "png", false)
                        },
                        text = R.string.weapons,
                    )
                )
            )
        )
    }

    fun onSwipeRefresh() {
        initState()
    }

    fun onDashboardItemClicked(item: DashboardItem) = viewModelScope.launch {
        when (item.dashboardItemType) {
            DashboardItemType.KAMIHIME -> eventChannel.send(Event.OpenKamihimeList)
        }
    }

    data class State(
        val items: List<DashboardItem>
    )

    sealed class Event {
        object OpenKamihimeList : Event()
    }
}
