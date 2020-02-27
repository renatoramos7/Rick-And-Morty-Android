package com.renatoramos.rickandmorty.data.store.local.paperdb.provider

import io.paperdb.Paper
import io.reactivex.rxjava3.core.Observable

class BaseRepositoryProvider {

    fun add(repos: List<Any>, tagKey: String ): Observable<List<Any>> {
        return Observable.create{ e ->
            try {
                Paper.book().delete(tagKey)
                Paper.book().write(tagKey, repos)
                e.onNext(repos)
                e.onComplete()
            } catch (exception: Exception) {
                e.onError(exception)
            }
        }
    }

    fun getAll(tagKey: String): Observable<List<Any>> {
        val repoList = Paper.book().read<List<Any>>(tagKey)

        return if (repoList != null) {
            Observable.just(repoList)
        } else {
            val poiListDTO: List<Any> = listOf()
            Observable.just(poiListDTO)
        }
    }
}