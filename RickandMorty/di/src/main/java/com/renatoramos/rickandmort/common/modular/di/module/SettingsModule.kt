package com.renatoramos.rickandmort.common.modular.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class SettingsModule {

    @Provides
    @Singleton
    @Named(BASE_URL)
    internal fun provideServerUrl(): String {
        return "https://rickandmortyapi.com/api/"
    }

    companion object {
        const val BASE_URL = "Settings.ServerUrl"
    }
}