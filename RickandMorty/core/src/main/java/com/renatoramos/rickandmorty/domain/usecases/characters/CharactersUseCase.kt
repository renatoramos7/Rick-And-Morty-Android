package com.renatoramos.rickandmorty.domain.usecases.characters

import com.renatoramos.rickandmorty.data.store.dto.characters.toCharacterViewObject
import com.renatoramos.rickandmorty.data.store.repository.characters.CharactersRepository
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject


class CharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    fun requestAllCharacters(page: Int): Maybe<MutableList<CharacterViewObject>> {
        return charactersRepository.requestAllCharacters(page).map { characterList ->
            characterList.map { it.toCharacterViewObject() }.toMutableList()
        }
    }

}