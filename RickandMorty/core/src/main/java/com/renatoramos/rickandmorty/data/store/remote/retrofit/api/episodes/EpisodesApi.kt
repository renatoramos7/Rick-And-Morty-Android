package com.renatoramos.rickandmorty.data.store.remote.retrofit.api.episodes

import com.renatoramos.rickandmorty.data.store.dto.episodes.EpisodeDTO
import com.renatoramos.rickandmorty.data.store.dto.response.RickAndMortyResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodesApi {
    @GET("episode/")
    fun getAllEpisodes(@Query("page") page: Int? = null): Observable<RickAndMortyResponse<EpisodeDTO>>

    @GET("episode/{episodeIds}")
    fun getEpisodes(@Path("episodeIds") episodeIds: List<Int>): Observable<List<EpisodeDTO>>

    @GET("episode/{episodeId}")
    fun getEpisode(@Path("episodeId") episodeId: Int): Observable<EpisodeDTO>
}