package com.renatoramos.rickandmorty.common.modular.di

import com.renatoramos.rickandmorty.MainApplication
import com.renatoramos.rickandmorty.common.modular.di.builder.ActivityBuilder
import com.renatoramos.rickandmorty.common.modular.di.builder.ViewModelBuilder
import com.renatoramos.rickandmorty.common.modular.di.module.ApplicationModule
import com.renatoramos.rickandmorty.common.modular.di.module.NetworkModule
import com.renatoramos.rickandmorty.common.modular.di.module.SettingsModule
import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.module.PaperDbProviderModule
import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.module.RepositoryModule
import com.renatoramos.rickandmorty.data.store.remote.retrofit.module.NetworkServiceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (ApplicationModule::class),
    (ViewModelBuilder::class),
    (ActivityBuilder::class),
    (SettingsModule::class),
    (NetworkModule::class),
    (NetworkServiceModule::class),
    (RepositoryModule::class),
    (PaperDbProviderModule::class)
])
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(mainApplication: MainApplication): Builder

        fun applicationModule(applicationModule: ApplicationModule): Builder
        fun build(): AppComponent
    }
}
