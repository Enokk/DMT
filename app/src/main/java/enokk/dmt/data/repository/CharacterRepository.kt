package enokk.dmt.data.repository

import enokk.dmt.data.local.CharacterDao
import enokk.dmt.data.local.toEntity
import enokk.dmt.data.local.toDomain
import enokk.dmt.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterRepository(private val dao: CharacterDao) {

    val characters: Flow<List<Character>> = dao.getAll().map { entities ->
        entities.map { it.toDomain() }
    }

    suspend fun addCharacter(character: Character) {
        dao.insert(character.toEntity())
    }

    suspend fun deleteCharacter(id: String) {
        dao.deleteById(id)
    }
}
