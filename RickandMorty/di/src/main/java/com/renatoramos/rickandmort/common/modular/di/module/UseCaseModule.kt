package com.renatoramos.rickandmort.common.modular.di.module

import com.renatoramos.rickandmorty.data.store.repository.characters.CharactersRepository
import com.renatoramos.rickandmorty.data.store.repository.episodes.EpisodesRepository
import com.renatoramos.rickandmorty.domain.usecases.characters.CharactersUseCase
import com.renatoramos.rickandmorty.domain.usecases.episodes.EpisodesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun providesCharactersUseCase(
        charactersRepository: CharactersRepository
    ): CharactersUseCase {
        return CharactersUseCase(charactersRepository)
    }

    @Provides
    @Singleton
    fun providesEpisodesUseCase(
        episodesRepository: EpisodesRepository
    ): EpisodesUseCase {
        return EpisodesUseCase(episodesRepository)
    }

}