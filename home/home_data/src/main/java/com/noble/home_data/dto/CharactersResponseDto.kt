package com.noble.home_data.dto

data class CharactersResponseDto(
    val info: Info?,
    val results: List<Result>?
){
    companion object{
        fun getCharacterResponseDao() = CharactersResponseDto(Info.getInfo(), Result.getResultList())
    }
}