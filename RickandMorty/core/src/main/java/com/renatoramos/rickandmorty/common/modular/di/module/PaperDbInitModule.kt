package com.renatoramos.rickandmorty.common.modular.di.module

import android.content.Context
import dagger.Module
import io.paperdb.Paper
import javax.inject.Singleton

@Module
class PaperDbInitModule {
    
    @Singleton
    fun providesInitPaperDb(applicationContext: Context) {
        Paper.init(applicationContext)
    }

}