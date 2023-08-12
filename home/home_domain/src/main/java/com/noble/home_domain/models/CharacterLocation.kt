package com.noble.home_domain.models

data class CharacterLocation(
    val name: String,
    val url: String
) {

    companion object {
        fun getCharacterLocation() = CharacterLocation(
            name = "",
            url = ""
        )
    }
}
