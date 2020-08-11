package com.renatoramos.rickandmorty.data.store.dto.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RickAndMortyResponse<T>(
    @Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val results: List<T>
)