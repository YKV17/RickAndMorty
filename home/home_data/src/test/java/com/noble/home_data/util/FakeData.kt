package com.noble.home_data.util

import com.noble.home_data.dto.CharactersResponseDto
import com.noble.home_data.dto.Info
import com.noble.home_data.dto.Location
import com.noble.home_data.dto.Origin
import com.noble.home_data.dto.Result
import com.noble.home_domain.models.Character

class FakeData {
    companion object{
        fun getCharacterResponseDtoWithNullList() = CharactersResponseDto.getCharacterResponseDaoNullList()
        fun getCharacterResponseDtoEmpty() = CharactersResponseDto.getCharacterResponseDao()
        fun getCharacterResponseDtoWithData(): CharactersResponseDto {
            val resultList = arrayListOf<Result>()
            resultList.add(
                getResult()
            )

            return CharactersResponseDto(Info.getInfo(), resultList)

        }

        fun getResult() = Result(
            created = "2017-12-26T17:43:58.410Z",
            episode = listOf<String>("https://rickandmortyapi.com/api/episode/18"),
            gender = "unknown",
            id = 125,
            image = "https://rickandmortyapi.com/api/character/avatar/125.jpeg",
            location = Location("Planet Squanch", "https://rickandmortyapi.com/api/location/35"),
            name = "Flansian",
            origin = Origin("unknown", ""),
            species = "Alien",
            status = "Alive",
            type = "Flansian",
            url = "https://rickandmortyapi.com/api/location/35"
        )
    }
}