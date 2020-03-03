package com.renatoramos.rickandmorty.data.store.repository.characters

import com.renatoramos.rickandmorty.data.store.dto.characters.CharacterDTO
import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.characters.CharacterProvider
import com.renatoramos.rickandmorty.data.store.remote.retrofit.api.characters.CharactersApi
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val charactersApi: CharactersApi,
    private val characterProvider: CharacterProvider
) {
    private val TAGKEY = CharactersRepository::class.java.simpleName

    fun requestAllCharacters(page: Int): Maybe<List<CharacterDTO>> {
        val remote = getAllCharactersRemote(page)
        val local = getAllCharactersLocal(page)

        return Observable.concatArrayDelayError(remote, local)
            .filter { list -> list != null }
            .firstElement()
    }

    /* Local Part */
    private fun getAllCharactersLocal(page: Int): Observable<List<CharacterDTO>> {
        return characterProvider.getAll(page, TAGKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /* Remote Part */
    private fun getAllCharactersRemote(page: Int): Observable<List<CharacterDTO>> {
        return charactersApi.getAllCharacters(page)
            .cache()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .concatMap { repos ->
                characterProvider.add(repos.results, page, TAGKEY)
            }
    }
}

