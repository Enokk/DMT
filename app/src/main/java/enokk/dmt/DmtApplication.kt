package enokk.dmt

import android.app.Application
import enokk.dmt.data.local.AppDatabase
import enokk.dmt.data.repository.CharacterRepository

class DmtApplication : Application() {

    val database by lazy { AppDatabase.getInstance(this) }
    val characterRepository by lazy { CharacterRepository(database.characterDao()) }
}
