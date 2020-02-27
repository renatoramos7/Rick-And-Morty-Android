package com.renatoramos.rickandmort.common.modular.di.module

import com.renatoramos.rickandmorty.domain.data.store.remote.retrofit.api.characters.CharactersApi
import com.renatoramos.rickandmorty.domain.data.store.remote.retrofit.api.episodes.EpisodesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkServiceModule {

    @Provides
    @Singleton
    fun providesCharactersApi(retrofit: Retrofit): CharactersApi {
        return retrofit.create(CharactersApi::class.java)
    }

    @Provides
    @Singleton
    fun providesEpisodesApi(retrofit: Retrofit): EpisodesApi {
        return retrofit.create(EpisodesApi::class.java)
    }

}