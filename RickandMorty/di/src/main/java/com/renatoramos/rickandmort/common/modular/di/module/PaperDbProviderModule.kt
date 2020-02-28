package com.renatoramos.rickandmort.common.modular.di.module

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.characters.CharacterProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PaperDbProviderModule {


    @Provides
    @Singleton
    fun providesPoiRepositoryProvider(): CharacterProvider {
        return CharacterProvider()
    }

}