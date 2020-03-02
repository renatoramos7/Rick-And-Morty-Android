package com.renatoramos.rickandmort.common.modular.di.builder

import com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.CharactersListFragment
import com.renatoramos.rickandmorty.common.modular.di.annotation.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun  provideCharactersListFragment(): CharactersListFragment

    //Add more Fragments here.
}