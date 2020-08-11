package com.renatoramos.rickandmorty.data.store.dto.episodes

import com.renatoramos.rickandmorty.domain.viewobject.episodes.EpisodeViewObject
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EpisodeDTO(
    @field:Json(name = "air_date")
    val airDate: String,
    @field:Json(name = "characters")
    val characters: List<String>,
    @field:Json(name = "created")
    val created: String,
    @field:Json(name = "episode")
    val episode: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
)

fun EpisodeDTO.toEpisodeViewObject(): EpisodeViewObject = EpisodeViewObject(
    airDate = airDate,
    characters = characters,
    created = created,
    episode = episode,
    id = id,
    name = name,
    url = url
)