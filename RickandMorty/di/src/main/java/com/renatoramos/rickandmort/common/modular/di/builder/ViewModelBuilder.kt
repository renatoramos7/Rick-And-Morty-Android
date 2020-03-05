package com.renatoramos.rickandmort.common.modular.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.renatoramos.rickandmorty.common.modular.di.annotation.ViewModelKey
import com.renatoramos.rickandmort.common.modular.di.factory.ViewModelFactory
import com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.CharactersListViewModel
import com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist.EpisodesListViewModel
import com.renatoramos.rickandmorty.home.presentation.ui.HomeAppViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    //Add more ViewModels here.
    @Binds
    @IntoMap
    @ViewModelKey(HomeAppViewModel::class)
    internal abstract  fun bindHomeAppViewModel(homeAppViewModel: HomeAppViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharactersListViewModel::class)
    internal abstract  fun bindCharactersListViewModel(charactersListViewModel: CharactersListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EpisodesListViewModel::class)
    internal abstract  fun bindEpisodesListViewModel(episodesListViewModel: EpisodesListViewModel): ViewModel



}