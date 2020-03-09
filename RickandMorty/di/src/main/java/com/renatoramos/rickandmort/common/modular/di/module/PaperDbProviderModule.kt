package com.renatoramos.rickandmort.common.modular.di.module

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.characters.CharacterProvider
import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.episodes.EpisodesProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PaperDbProviderModule {

    @Provides
    @Singleton
    fun providesCharacterProvider(): CharacterProvider {
        return CharacterProvider()
    }

    @Provides
    @Singleton
    fun providesEpisodesProvider(): EpisodesProvider {
        return EpisodesProvider()
    }

}