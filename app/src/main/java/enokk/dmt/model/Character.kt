package enokk.dmt.model

data class Character(
    val id: String,
    val name: String,
    val race: String = "—",
    val characterClass: String = "—",
    val level: Int = 1
)
