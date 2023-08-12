package com.noble.home_data.mapper

import com.noble.home_data.dto.CharactersResponseDto
import com.noble.home_data.dto.Location
import com.noble.home_data.dto.Result
import com.noble.home_domain.models.Character
import com.noble.home_domain.models.CharacterLocation

fun Result?.toDomainModel(): Character {
    return Character(
        created = this?.created ?: "",
        gender = this?.gender ?: "",
        id = this?.id ?: 0,
        image = this?.image?: "",
        characterLocation = this?.location.toDomainModel(),
        name = this?.name?:"",
        species = this?.species?:"",
        status = this?.status?:"",
        type = this?.type?:"",
        url = this?.url?:"",
        isBookMarked = false
    )
}

fun Location?.toDomainModel(): CharacterLocation {
    return CharacterLocation(
        name = this?.name ?: "",
        url = this?.url ?: ""
    )
}