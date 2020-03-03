package com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.renatoramos.rickandmorty.domain.usecases.characters.CharactersUseCase
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
import io.reactivex.disposables.CompositeDisposable

class CharactersDataSourceFactory (
    private val compositeDisposable: CompositeDisposable,
    private val charactersUseCase: CharactersUseCase
) : DataSource.Factory<Int, CharacterViewObject>() {

    var listRepositoriesDataSourceLiveData = MutableLiveData<CharactersDataSource>()

    override fun create(): DataSource<Int, CharacterViewObject> {
        val listRepositoriesDataSource = CharactersDataSource(compositeDisposable, charactersUseCase)
        listRepositoriesDataSourceLiveData.postValue(listRepositoriesDataSource)
        return listRepositoriesDataSource
    }
}