package com.renatoramos.rickandmorty.data.store.dto.characters

import com.renatoramos.rickandmorty.data.store.dto.locations.LocationShortDTO
import com.renatoramos.rickandmorty.data.store.dto.locations.toLocationShortViewObject
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDTO(
    @Json(name = "created")
    val created: String,
    @Json(name = "episode")
    val episodes: List<String>,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "location")
    val location: LocationShortDTO,
    @Json(name = "name")
    val name: String,
    @Json(name = "origin")
    val origin: LocationShortDTO,
    @Json(name = "species")
    val species: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String
): Any()

fun CharacterDTO.toCharacterViewObject(): CharacterViewObject = CharacterViewObject(
        created = this.created,
        episodes = this.episodes,
        gender = this.gender,
        id = this.id,
        image = this.image,
        location = this.location.toLocationShortViewObject(),
        origin = this.origin.toLocationShortViewObject(),
        name = this.name,
        species = this.species,
        status = this.status,
        type = this.type,
        url = this.url
)


