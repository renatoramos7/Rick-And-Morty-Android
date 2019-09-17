package com.renatoramos.rickandmorty.data.store.remote.retrofit.dto.poi

import com.google.gson.annotations.SerializedName

data class CoordinateDTO(
    @SerializedName("latitude")
    val latitude: Double?,

    @SerializedName("longitude")
    val longitude: Double?
)