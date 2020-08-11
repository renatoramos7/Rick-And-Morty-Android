package com.renatoramos.rickandmorty.data.store.dto.locations

import com.renatoramos.rickandmorty.domain.viewobject.locations.LocationShortViewObject
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationShortDTO(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
)

fun LocationShortDTO.toLocationShortViewObject(): LocationShortViewObject = LocationShortViewObject(
    name = this.name,
    url = this.url
)