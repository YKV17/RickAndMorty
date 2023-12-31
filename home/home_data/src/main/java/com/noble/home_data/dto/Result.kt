package com.noble.home_data.dto

data class Result(
    val created: String?,
    val episode: List<String>?,
    val gender: String?,
    val id: Long?,
    val image: String?,
    val location: Location?,
    val name: String?,
    val origin: Origin?,
    val species: String?,
    val status: String?,
    val type: String?,
    val url: String?
) {
    companion object {
        fun getResult() = Result(
            created = "",
            episode = listOf<String>(),
            gender = "",
            id = 0,
            image = "",
            location = Location.getLocation(),
            name = "",
            origin = Origin.getOrigin(),
            species = "",
            status = "",
            type = "",
            url = ""
        )

        fun getResultList() = listOf<Result>()
    }
}