package com.renatoramos.rickandmorty.data.store.local.paperdb.provider.module

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.PoiRepositoryProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PaperDbProviderModule {

    @Provides
    @Singleton
    fun providesPoiRepositoryProvider(): PoiRepositoryProvider {
        return PoiRepositoryProvider()
    }

}