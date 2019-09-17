package com.renatoramos.rickandmorty.common.di.builder

import com.renatoramos.rickandmorty.common.modular.di.annotation.ActivityScope
import com.renatoramos.rickandmorty.presentation.ui.main.MainAppActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {


    @ActivityScope
    @ContributesAndroidInjector()
/*        modules = [
            VehiclesFragmentBuilder::class
        ]
    )*/
    internal abstract fun bindMainActivityModule(): MainAppActivity

    // Case you need add more Activity here

}
