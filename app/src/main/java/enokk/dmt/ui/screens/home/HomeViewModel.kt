package enokk.dmt.ui.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Lo stato della schermata Home — tutto quello che la UI deve mostrare
data class HomeUiState(
    val message: String = "Benvenuto in DMT!"
)

class HomeViewModel : ViewModel() {

    // _uiState è privato e mutabile — solo il ViewModel può cambiarlo
    private val _uiState = MutableStateFlow(HomeUiState())

    // uiState è pubblico e in sola lettura — la UI può solo osservarlo
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
}
