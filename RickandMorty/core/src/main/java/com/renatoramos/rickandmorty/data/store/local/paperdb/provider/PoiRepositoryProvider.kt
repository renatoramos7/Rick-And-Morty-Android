package com.renatoramos.rickandmorty.data.store.local.paperdb.provider


import com.renatoramos.rickandmorty.data.store.remote.retrofit.dto.poi.PoiListDTO
import io.paperdb.Paper
import io.reactivex.rxjava3.core.Observable

class PoiRepositoryProvider {
    private val TAGKEY = PoiRepositoryProvider::class.java.simpleName

    fun add(repos: List<PoiListDTO>): Observable<List<PoiListDTO>> {
        return Observable.create { e ->
            try {
                Paper.book().delete(TAGKEY)
                Paper.book().write(TAGKEY, repos)
                e.onNext(repos)
                e.onComplete()
            } catch (exception: Exception) {
                e.onError(exception)
            }
        }
    }

    fun getAll(): Observable<List<PoiListDTO>> {
        val repoList = Paper.book().read<List<PoiListDTO>>(TAGKEY)

        return if (repoList != null) {
            Observable.just(repoList)
        } else {
            val poiListDTO: List<PoiListDTO> = listOf()
            Observable.just(poiListDTO)
        }
    }
}