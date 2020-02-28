package com.renatoramos.rickandmort.common.modular.di.module

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.characters.CharacterProvider
import com.renatoramos.rickandmorty.data.store.remote.retrofit.api.characters.CharactersApi
import com.renatoramos.rickandmorty.data.store.remote.retrofit.api.episodes.EpisodesApi
import com.renatoramos.rickandmorty.data.store.repository.characters.CharactersRepository
import com.renatoramos.rickandmorty.data.store.repository.episodes.EpisodesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesCharactersRepository(
        charactersApi: CharactersApi,
        characterProvider: CharacterProvider
    ): CharactersRepository {
        return CharactersRepository(charactersApi, characterProvider)
    }

    @Provides
    @Singleton
    fun providesEpisodesRepository(
        episodesApi: EpisodesApi
    ): EpisodesRepository {
        return EpisodesRepository(episodesApi)
    }


}