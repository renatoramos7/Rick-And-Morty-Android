package com.renatoramos.rickandmorty.data.store.remote.retrofit.dto.poi

data class PoiListDTO(
    val id: Int?,
    val coordinateDTO: CoordinateDTO?,
    val fleetType: String?,
    val heading: Double?
)
