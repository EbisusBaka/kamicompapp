package ebisus.monkagiga.kamicompapp.android.ui.chara

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharaListViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(State(emptyList()))
    val uiState: StateFlow<State> = _uiState

    private val eventChannel = Channel<Event>(Channel.CONFLATED)
    val eventsFlow = eventChannel.receiveAsFlow()

    init {
        createItems()
    }

    private fun createItems() = viewModelScope.launch {
        val items = ((5001..5220L).toList() + (6000..6300L).toList() + (7000..7220L).toList()).map {
            CharaListItem(it)
        }
        _uiState.emit(
            _uiState.value.copy(items = items)
        )
    }

    fun onCharacterClicked(item: CharaListItem) = viewModelScope.launch {
        eventChannel.send(Event.NavigateToDetails(item.id))
    }

    data class State(
        val items: List<CharaListItem>
    )

    sealed class Event {
        data class NavigateToDetails(val id: Long) : Event()
    }
}
