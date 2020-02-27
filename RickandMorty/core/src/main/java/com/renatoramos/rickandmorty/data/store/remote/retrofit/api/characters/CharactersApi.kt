package com.renatoramos.rickandmorty.data.store.remote.retrofit.api.characters

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersApi {
    @GET("character/")
    fun getAllCharacters(@Query("page") page: Int? = null): Observable<List<Character>>

    @GET("character/{characterIds}")
    fun getCharacters(@Path("characterIds") characterIds: List<Int>): Observable<List<Character>>

    @GET("character/{characterId}")
    fun getCharacter(@Path("characterId") characterId: Int): Observable<Character>
}