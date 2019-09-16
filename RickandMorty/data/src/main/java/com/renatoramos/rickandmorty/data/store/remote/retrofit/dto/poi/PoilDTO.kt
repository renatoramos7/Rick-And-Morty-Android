package com.renatoramos.rickandmorty.data.store.remote.retrofit.dto.poi

import com.google.gson.annotations.SerializedName

data class PoilDTO (
    @SerializedName("poiList")
    val poiList: List<PoiListDTO>
    )