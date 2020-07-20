package com.renatoramos.rickandmorty.data.store.dto.episodes

import com.renatoramos.rickandmorty.domain.viewobject.episodes.EpisodeViewObject
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EpisodeDTO(
    @Json(name = "air_date")
    val airDate: String,
    @Json(name = "characters")
    val characters: List<String>,
    @Json(name = "created")
    val created: String,
    @Json(name = "episode")
    val episode: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
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