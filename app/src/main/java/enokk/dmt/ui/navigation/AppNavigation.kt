package enokk.dmt.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import enokk.dmt.DmtApplication
import enokk.dmt.ui.screens.home.HomeScreen
import enokk.dmt.ui.screens.home.HomeViewModel
import enokk.dmt.ui.screens.settings.SettingsScreen
import enokk.dmt.ui.screens.settings.SettingsViewModel

object Routes {
    const val HOME = "home"
    const val SETTINGS = "settings"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val app = LocalContext.current.applicationContext as DmtApplication

    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                viewModel = viewModel(factory = HomeViewModel.factory(app.characterRepository)),
                onNavigateToSettings = { navController.navigate(Routes.SETTINGS) }
            )
        }
        composable(Routes.SETTINGS) {
            SettingsScreen(
                viewModel = viewModel(factory = SettingsViewModel.factory(app.userPreferencesRepository)),
                onBack = { navController.popBackStack() }
            )
        }
    }
}
