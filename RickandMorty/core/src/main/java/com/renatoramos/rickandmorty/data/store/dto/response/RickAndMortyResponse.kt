package com.renatoramos.rickandmorty.data.store.dto.response

data class RickAndMortyResponse<T>(
    val info: Info,
    val results: List<T>
)