package com.renatoramos.rickandmort.common.modular.di.module

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.BaseRepositoryProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PaperDbProviderModule {


    @Provides
    @Singleton
    fun providesPoiRepositoryProvider(): BaseRepositoryProvider {
        return BaseRepositoryProvider()
    }

}