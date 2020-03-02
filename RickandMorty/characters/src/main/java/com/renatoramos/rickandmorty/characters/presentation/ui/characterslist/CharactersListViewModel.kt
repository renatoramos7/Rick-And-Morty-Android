package com.renatoramos.rickandmorty.characters.presentation.ui.characterslist

import com.renatoramos.rickandmorty.common.base.BaseViewModel
import com.renatoramos.rickandmorty.domain.usecases.characters.CharactersUseCase
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(private val charactersUseCase: CharactersUseCase) :
    BaseViewModel() {

    override fun onCleared() {
        super.onCleared()
        onStopDisposable()
    }

    fun getAllCharacters() {
        addDisposable(charactersUseCase.requestAllCharacters(1)
            .subscribe(
                { list -> onSuccess(list) },
                { throwable -> onError(throwable) }
            ))
    }

    private fun onSuccess(characterViewObject: MutableList<CharacterViewObject>) {
        var opa = "dadadadada"
    }

    private fun onError(throwable: Throwable) {
        var opa = "dadadadada"
    }

}