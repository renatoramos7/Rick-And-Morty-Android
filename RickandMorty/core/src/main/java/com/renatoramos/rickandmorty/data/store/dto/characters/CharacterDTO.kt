package com.renatoramos.rickandmorty.data.store.dto.characters

import com.renatoramos.rickandmorty.data.store.dto.locations.LocationShortDTO
import com.renatoramos.rickandmorty.data.store.dto.locations.toLocationShortViewObject
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDTO(
    @field:Json(name = "created")
    val created: String,
    @field:Json(name = "episode")
    val episodes: List<String>,
    @field:Json(name = "gender")
    val gender: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "location")
    val location: LocationShortDTO,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "origin")
    val origin: LocationShortDTO,
    @field:Json(name = "species")
    val species: String,
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "url")
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


