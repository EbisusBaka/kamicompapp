package ebisus.monkagiga.kamicompapp.android.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ebisus.monkagiga.kamicompapp.core.domain.scripts.PopulateDatabaseScript
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val populateDatabaseScript: PopulateDatabaseScript
) : ViewModel() {

    private val _uiState = MutableStateFlow(State(emptyList()))
    val uiState: StateFlow<State> = _uiState

    private val eventChannel = Channel<Event>(Channel.CONFLATED)
    val eventsFlow = eventChannel.receiveAsFlow()

    init {
        createItems()
    }

    private fun createItems() = viewModelScope.launch {
        populateDatabaseScript.populate()
        val items = ((5001..5220).toList() + (6000..6300).toList() + (7000..7220).toList()).map {
            TestItem(it)
        }
        _uiState.emit(
            _uiState.value.copy(items = items)
        )
    }

    data class State(
        val items: List<TestItem>
    )

    sealed class Event {

    }
}
