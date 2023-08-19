package com.noble.home_data.dto

data class Info(
    val count: Int ?,
    val next: String ?,
    val pages: Int ?,
    val prev: String?
){
    companion object{
        fun getInfo() = Info(
            count = 0,
            next = "",
            pages = 0,
            prev = ""
        )
    }
}