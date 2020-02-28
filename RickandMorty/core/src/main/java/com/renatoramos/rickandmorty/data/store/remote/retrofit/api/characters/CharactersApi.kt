package com.renatoramos.rickandmorty.data.store.remote.retrofit.api.characters

import com.renatoramos.rickandmorty.data.store.dto.characters.CharacterDTO
import com.renatoramos.rickandmorty.data.store.dto.response.RickAndMortyResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersApi {
    @GET("character/")
    fun getAllCharacters(@Query("page") page: Int? = null): Observable<RickAndMortyResponse<CharacterDTO>>

    @GET("character/{characterIds}")
    fun getCharacters(@Path("characterIds") characterIds: List<Int>): Observable<List<CharacterDTO>>

    @GET("character/{characterId}")
    fun getCharacter(@Path("characterId") characterId: Int): Observable<CharacterDTO>
}