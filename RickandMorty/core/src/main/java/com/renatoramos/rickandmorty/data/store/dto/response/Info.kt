package com.renatoramos.rickandmorty.data.store.dto.response

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)