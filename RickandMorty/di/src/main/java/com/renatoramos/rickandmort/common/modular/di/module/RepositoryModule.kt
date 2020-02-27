package com.renatoramos.rickandmort.common.modular.di.module

import com.renatoramos.rickandmorty.domain.data.store.local.paperdb.provider.BaseRepositoryProvider
import com.renatoramos.rickandmorty.domain.data.store.remote.retrofit.api.characters.CharactersApi
import com.renatoramos.rickandmorty.domain.data.store.remote.retrofit.api.episodes.EpisodesApi
import com.renatoramos.rickandmorty.domain.data.store.repository.characters.CharactersRepository
import com.renatoramos.rickandmorty.domain.data.store.repository.episodes.EpisodesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesCharactersRepository(
        charactersApi: CharactersApi,
        baseRepositoryProvider: BaseRepositoryProvider
    ): CharactersRepository {
        return CharactersRepository(charactersApi, baseRepositoryProvider)
    }

    @Provides
    @Singleton
    fun providesEpisodesRepository(
        episodesApi: EpisodesApi,
        baseRepositoryProvider: BaseRepositoryProvider
    ): EpisodesRepository {
        return EpisodesRepository(episodesApi, baseRepositoryProvider)
    }


}