package ebisus.monkagiga.kamicompapp.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ebisus.monkagiga.kamicompapp.core.domain.scripts.PopulateDatabaseScript
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleActivityViewModel @Inject constructor(
    private val populateDatabaseScript: PopulateDatabaseScript
) : ViewModel() {

    init {
        viewModelScope.launch {
            populateDatabaseScript.populate()
        }
    }
}
