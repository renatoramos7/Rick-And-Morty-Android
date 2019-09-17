package com.renatoramos.rickandmorty.common.modular.di.module

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.PoiRepositoryProvider
import com.renatoramos.rickandmorty.data.store.remote.retrofit.repository.poi.PoiRepository
import com.renatoramos.rickandmorty.data.store.remote.retrofit.service.poi.PoiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesPoiRepository(poiService: PoiService, poiRepositoryProvider: PoiRepositoryProvider): PoiRepository {
        return PoiRepository(poiService, poiRepositoryProvider)
    }
}