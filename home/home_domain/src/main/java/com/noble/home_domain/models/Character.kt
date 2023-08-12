package com.noble.home_domain.models

data class Character(
    val created: String,
    val gender: String,
    val id: Long,
    val image: String,
    val characterLocation: CharacterLocation,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    var isBookMarked: Boolean
){
    companion object{
        fun getCharacter() = Character(
            created = "",
            gender = "",
            id = 0,
            image = "",
            characterLocation = CharacterLocation.getCharacterLocation(),
            name = "",
            species = "",
            status = "",
            type = "",
            url = "",
            isBookMarked = false
        )

        fun getCharacterList() = listOf<Character>()
    }
}




