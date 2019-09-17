package com.renatoramos.rickandmorty.common.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.renatoramos.rickandmorty.common.modular.di.annotation.ViewModelKey
import com.renatoramos.rickandmorty.common.modular.di.factory.ViewModelFactory
import com.renatoramos.rickandmorty.presentation.ui.main.MainAppViewModel
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
    @ViewModelKey(MainAppViewModel::class)
    internal abstract  fun bindMapViewModel(mainAppViewModel: MainAppViewModel): ViewModel

/*    @Binds
    @IntoMap
    @ViewModelKey(VehicleListViewModel::class)
    internal abstract  fun bindVehicleListViewModel(vehicleListViewModel: VehicleListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(VehicleMapsViewModel::class)
    internal abstract  fun bindVehicleMapsViewModel(vehicleMapsViewModel: VehicleMapsViewModel): ViewModel*/

}