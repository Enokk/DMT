package enokk.dmt

import android.app.Application
import enokk.dmt.data.local.AppDatabase
import enokk.dmt.data.repository.CharacterRepository
import enokk.dmt.data.repository.UserPreferencesRepository

class DmtApplication : Application() {

    val database by lazy { AppDatabase.getInstance(this) }
    val characterRepository by lazy { CharacterRepository(database.characterDao()) }
    val userPreferencesRepository by lazy { UserPreferencesRepository(this) }
}
