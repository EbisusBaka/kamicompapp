package ebisus.monkagiga.kamicompapp.android.ui.photozoom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ebisus.monkagiga.kamicompapp.core.domain.ImageResourceProvider
import ebisus.monkagiga.kamicompapp.core.domain.models.KamihimeDetails
import ebisus.monkagiga.kamicompapp.core.domain.repository.KamihimeRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoZoomViewModel @Inject constructor(
    private val kamihimeRepository: KamihimeRepository,
    private var imageResourceProvider: ImageResourceProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<State?>(null)
    val uiState: Flow<State> = _uiState.filterNotNull()

    private val eventChannel = Channel<Event>(Channel.CONFLATED)
    val eventsFlow = eventChannel.receiveAsFlow()

    fun getData(id: Int) = viewModelScope.launch {
        val kamihimeDetails = kamihimeRepository.getKamihimeDetails(id)
        _uiState.emit(
            State(
                data = kamihimeDetails,
                imageUrl = imageResourceProvider.getPath("illustzoom", "chara", id, 0, "png")
            )
        )
    }

    data class State(
        val imageUrl: String,
        val data: KamihimeDetails? = null
    )

    sealed class Event {

    }
}
