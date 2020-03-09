package com.renatoramos.rickandmorty.data.store.dto.episodes

import com.renatoramos.rickandmorty.domain.viewobject.episodes.EpisodeViewObject
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EpisodeDTO(
    @Json(name = "air_date")
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
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