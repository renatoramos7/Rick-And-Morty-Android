package com.renatoramos.rickandmorty.domain.viewobject.episodes

data class EpisodeViewObject(
var airDate : String = "",
var characters: List<String> = listOf(),
var created : String = "",
var episode : String = "",
var id: Int = 0,
var name : String = "",
var url: String = ""
)