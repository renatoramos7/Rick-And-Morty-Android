package com.renatoramos.rickandmort.common.modular.di.module

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.BaseRepositoryProvider
import com.renatoramos.rickandmorty.data.store.remote.retrofit.repository.poi.PoiRepository
import com.renatoramos.rickandmorty.data.store.remote.retrofit.service.poi.PoiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesPoiRepository(poiService: PoiService, baseRepositoryProvider: BaseRepositoryProvider): PoiRepository {
        return PoiRepository(poiService, baseRepositoryProvider)
    }


}