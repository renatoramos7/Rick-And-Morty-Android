package com.renatoramos.rickandmort.common.modular.di.builder

import com.renatoramos.rickandmorty.common.modular.di.annotation.ActivityScope
import com.renatoramos.rickandmorty.home.presentation.ui.HomeAppActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun bindMainActivityModule(): HomeAppActivity

    // Case you need add more Activity here

}
