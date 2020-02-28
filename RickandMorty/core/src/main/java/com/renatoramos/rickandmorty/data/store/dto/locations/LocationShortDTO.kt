package com.renatoramos.rickandmorty.data.store.dto.locations

import com.renatoramos.rickandmorty.domain.viewobject.locations.LocationShortViewObject

data class LocationShortDTO(
    val name: String,
    val url: String
)

fun LocationShortDTO.toLocationShortViewObject(): LocationShortViewObject = LocationShortViewObject(
    name = this.name,
    url = this.url
)