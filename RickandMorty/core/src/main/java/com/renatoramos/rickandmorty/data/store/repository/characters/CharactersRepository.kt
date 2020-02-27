package com.renatoramos.rickandmorty.data.store.repository.characters

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.BaseRepositoryProvider
import com.renatoramos.rickandmorty.data.store.remote.retrofit.api.characters.CharactersApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val charactersApi: CharactersApi,
    private val baseRepositoryProvider: BaseRepositoryProvider
) {
    private val TAGKEY = CharactersRepository::class.java.simpleName

    fun requestRepositories(page: Int): @NonNull Maybe<List<Any>>? {
        val remote = getAllCharactersRemote(page)
        val local = getAllCharactersLocal(page)

        return Observable.concatArrayDelayError(remote, local)
            .filter { list -> list != null }
            .firstElement()
    }

    /* Local Part */
    private fun getAllCharactersLocal(page: Int): Observable<List<Any>> {
        return baseRepositoryProvider.getAll(TAGKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /* Remote Part */
    private fun getAllCharactersRemote(page: Int): Observable<List<Any>> {
        return charactersApi.getAllCharacters(page)
            .cache()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .concatMap { repos -> baseRepositoryProvider.add(repos, TAGKEY) }
    }
}

