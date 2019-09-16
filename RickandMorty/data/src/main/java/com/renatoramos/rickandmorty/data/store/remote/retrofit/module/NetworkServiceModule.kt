package com.renatoramos.rickandmorty.data.store.remote.retrofit.module

import com.renatoramos.rickandmorty.data.store.remote.retrofit.service.poi.PoiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkServiceModule {

    @Provides
    @Singleton
    fun providesReposService(retrofit: Retrofit): PoiService {
        return retrofit.create(PoiService::class.java)
    }
}