package com.renatoramos.rickandmorty.data.store.dto.characters

import com.renatoramos.rickandmorty.data.store.dto.locations.LocationShortDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDTO(
    val created: String,
    @Json(name = "episode")
    val episodes: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationShortDTO,
    val origin: LocationShortDTO,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)