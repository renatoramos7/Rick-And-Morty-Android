package com.renatoramos.rickandmorty.domain.data.store.remote.retrofit.api.episodes

import com.renatoramos.rickandmorty.domain.data.store.dto.episodes.EpisodeDTO
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodesApi {
    @GET("episode/")
    fun getAllEpisodes(@Query("page") page: Int? = null): Observable<List<EpisodeDTO>>

    @GET("episode/{episodeIds}")
    fun getEpisodes(@Path("episodeIds") episodeIds: List<Int>): Observable<List<EpisodeDTO>>

    @GET("episode/{episodeId}")
    fun getEpisode(@Path("episodeId") episodeId: Int): Observable<EpisodeDTO>
}