package com.renatoramos.rickandmort.common.modular.di.module

import com.renatoramos.rickandmorty.data.store.repository.characters.CharactersRepository
import com.renatoramos.rickandmorty.domain.usecases.characters.CharactersUseCase
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



}