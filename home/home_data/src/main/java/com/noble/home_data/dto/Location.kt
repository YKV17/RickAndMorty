package com.noble.home_data.dto

data class Location(
    val name: String?,
    val url: String?
){
    companion object{
        fun getLocation() = Location("", "")
    }
}