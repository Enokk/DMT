package enokk.dmt.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import enokk.dmt.model.AppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

class UserPreferencesRepository(private val context: Context) {

    private val THEME_KEY = stringPreferencesKey("app_theme")

    val appTheme: Flow<AppTheme> = context.dataStore.data.map { prefs ->
        val name = prefs[THEME_KEY] ?: AppTheme.SYSTEM.name
        AppTheme.entries.find { it.name == name } ?: AppTheme.SYSTEM
    }

    suspend fun setAppTheme(theme: AppTheme) {
        context.dataStore.edit { it[THEME_KEY] = theme.name }
    }
}
