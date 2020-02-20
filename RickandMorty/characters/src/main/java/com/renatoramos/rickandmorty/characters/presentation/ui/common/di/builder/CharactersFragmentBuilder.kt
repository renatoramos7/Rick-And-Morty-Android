package com.renatoramos.rickandmorty.characters.presentation.ui.common.di.builder

import com.renatoramos.rickandmorty.characters.presentation.ui.characterslist.CharactersListFragment
import com.renatoramos.rickandmorty.common.modular.di.annotation.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CharactersFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun  provideCharactersListFragment(): CharactersListFragment

    //Add more Fragments here.
}