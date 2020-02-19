package com.renatoramos.rickandmorty.data.store.remote.retrofit.service.poi

import com.renatoramos.rickandmorty.data.store.remote.retrofit.dto.poi.PoilDTO
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PoiService {

    //https://fake-poi-api.mytaxi.com/?p1Lat={53.694865}&p1Lon={9.757589}&p2Lat={53.394655}&p2Lon={10.099891}
    //(53.694865, 9.757589 & 53.394655, 10.099891).

    @GET(".")
    fun requestPoiList(
        @Query("p1Lat") p1Lat: String,
        @Query("p1Lon") p1Lon: String,
        @Query("p2Lat") p2Lat: String,
        @Query("p2Lon") p2Lon: String
    ): Observable<PoilDTO>

}