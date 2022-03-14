package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ebisus.monkagiga.kamicompapp.core.domain.embedded.KamihimeDetails
import ebisus.monkagiga.kamicompapp.core.domain.repository.KamihimeRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharaDetailsViewModel @Inject constructor(
    private val kamihimeRepository: KamihimeRepository,
    private val charaDetailsItemTransformer: CharaDetailsItemTransformer
) : ViewModel() {

    private val _uiState = MutableStateFlow<State?>(null)
    val uiState: Flow<State> = _uiState.filterNotNull()

    private val eventChannel = Channel<Event>(Channel.CONFLATED)
    val eventsFlow = eventChannel.receiveAsFlow()

    fun getData(id: Long) = viewModelScope.launch {
        val kamihimeDetails = kamihimeRepository.getKamihimeDetails(id)
        _uiState.emit(
            State(
                id = id,
                data = kamihimeDetails,
                items = charaDetailsItemTransformer.transform(id, kamihimeDetails, sfw = false)
            )
        )
    }

    fun onSfwButtonClicked() = viewModelScope.launch {
        val state = _uiState.value ?: return@launch
        val data = state.data
        val newSfw = !state.sfw
        _uiState.emit(
            state.copy(
                sfw = newSfw,
                items = charaDetailsItemTransformer.transform(state.id, data, sfw = newSfw)
            )
        )
    }

    data class State(
        val id: Long,
        val data: KamihimeDetails? = null,
        val sfw: Boolean = false,
        val items: List<CharaDetailsItem>
    )

    sealed class Event
}
