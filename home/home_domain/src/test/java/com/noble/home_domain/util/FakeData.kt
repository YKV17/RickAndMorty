package com.noble.home_domain.util

import com.noble.home_domain.models.Character

class FakeData {
    companion object{
        fun getCharacters(): List<Character>{
            return listOf(
                Character.getCharacter(),
                Character.getCharacter()
            )
        }
    }
}