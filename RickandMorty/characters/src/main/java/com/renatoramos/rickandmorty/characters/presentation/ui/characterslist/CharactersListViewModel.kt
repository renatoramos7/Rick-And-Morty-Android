package com.renatoramos.rickandmorty.characters.presentation.ui.characterslist

import com.renatoramos.rickandmorty.common.base.BaseViewModel
import com.renatoramos.rickandmorty.domain.usecases.characters.CharactersUseCase
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(charactersUseCase: CharactersUseCase): BaseViewModel() {

    override fun onCleared() {
        super.onCleared()
        onStopDisposable()
    }

    init {
        addDisposable(charactersUseCase.requestAllCharacters(1)
            .subscribe(
                { list -> onSuccess(list) },
                { throwable -> onError(throwable) }
            ))
    }

    private fun onSuccess(characterViewObject : MutableList<CharacterViewObject>) {
        var opa = "dadadadada"
    }

    private fun onError(throwable: Throwable) {
        var opa = "dadadadada"
    }





}