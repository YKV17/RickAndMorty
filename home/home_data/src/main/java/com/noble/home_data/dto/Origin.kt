package com.noble.home_data.dto

data class Origin(
    val name: String?,
    val url: String?
){
    companion object{
        fun getOrigin() = Origin("","")
    }
}