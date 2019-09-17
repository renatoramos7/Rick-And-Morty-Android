package com.renatoramos.rickandmorty.data.store.remote.retrofit.dto.poi

import com.google.gson.annotations.SerializedName

data class PoiListDTO(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("coordinate")
    val coordinateDTO: CoordinateDTO?,

    @SerializedName("fleetType")
    val fleetType: String?,

    @SerializedName("heading")
    val heading: Double?
)
