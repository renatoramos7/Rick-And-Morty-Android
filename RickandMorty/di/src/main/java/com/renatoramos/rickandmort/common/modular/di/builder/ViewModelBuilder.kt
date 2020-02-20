package com.renatoramos.rickandmort.common.modular.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.renatoramos.rickandmorty.common.modular.di.annotation.ViewModelKey
import com.renatoramos.rickandmort.common.modular.di.factory.ViewModelFactory
import com.renatoramos.rickandmorty.characters.presentation.ui.characterslist.CharactersListViewModel
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
    @ViewModelKey(CharactersListViewModel::class)
    internal abstract  fun bindCharactersListViewModel(mainAppViewModel: CharactersListViewModel): ViewModel

/*    @Binds
    @IntoMap
    @ViewModelKey(VehicleListViewModel::class)
    internal abstract  fun bindVehicleListViewModel(vehicleListViewModel: VehicleListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(VehicleMapsViewModel::class)
    internal abstract  fun bindVehicleMapsViewModel(vehicleMapsViewModel: VehicleMapsViewModel): ViewModel*/

}