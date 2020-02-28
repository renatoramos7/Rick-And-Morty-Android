package com.renatoramos.rickandmorty.data.store.dto.characters

import com.renatoramos.rickandmorty.data.store.dto.locations.LocationShortDTO
import com.renatoramos.rickandmorty.data.store.dto.locations.toLocationShortViewObject
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
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
    val name: String,
    val origin: LocationShortDTO,
    val species: String,
    val status: String,
    val type: String,
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


