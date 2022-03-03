package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ebisus.monkagiga.kamicompapp.core.domain.ImageResourceProvider
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
    private var imageResourceProvider: ImageResourceProvider
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
                imageUrl = imageResourceProvider.getPath("illust-com-kneeshot", "chara", id, 0, "png", sfw = false)
            )
        )
    }

    fun onSfwButtonClicked() = viewModelScope.launch {
        val state = _uiState.value ?: return@launch
        val newSfw = !state.sfw
        _uiState.emit(
            state.copy(
                sfw = newSfw,
                imageUrl = imageResourceProvider.getPath("illust-com-kneeshot", "chara", state.id, 0, "png", sfw = newSfw)
            )
        )
    }

    data class State(
        val id: Long,
        val imageUrl: String,
        val data: KamihimeDetails? = null,
        val sfw: Boolean = false
    )

    sealed class Event
}
