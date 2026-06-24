package enokk.dmt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import enokk.dmt.model.AppTheme
import enokk.dmt.ui.navigation.AppNavigation
import enokk.dmt.ui.theme.DMTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = application as DmtApplication
        enableEdgeToEdge()
        setContent {
            val appTheme by app.userPreferencesRepository.appTheme
                .collectAsStateWithLifecycle(initialValue = AppTheme.SYSTEM)
            DMTTheme(appTheme = appTheme) {
                AppNavigation()
            }
        }
    }
}
