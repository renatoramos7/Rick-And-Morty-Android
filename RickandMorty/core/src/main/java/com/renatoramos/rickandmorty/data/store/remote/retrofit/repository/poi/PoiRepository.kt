package com.renatoramos.rickandmorty.data.store.remote.retrofit.repository.poi

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.PoiRepositoryProvider
import com.renatoramos.rickandmorty.data.store.remote.retrofit.dto.poi.PoiListDTO
import com.renatoramos.rickandmorty.data.store.remote.retrofit.service.poi.PoiService
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PoiRepository @Inject constructor(
    private val reposService: PoiService,
    private val poiRepositoryProvider: PoiRepositoryProvider
) {

    fun requestRepositories(): Maybe<List<PoiListDTO>> {
        val remote = getRepositoriesRemote()
        val local = getRepositoriesLocal()

        return Observable.concatArrayDelayError(remote, local)
            .filter { list -> list != null }
            .firstElement()
    }

    /* Local Part */
    private fun getRepositoriesLocal(): Observable<List<PoiListDTO>> {
        return poiRepositoryProvider.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /* Remote Part */
    private fun getRepositoriesRemote(): Observable<List<PoiListDTO>> {
        return reposService.requestPoiList(
            "53.694865",
            "9.757589",
            "53.394655",
            "10.099891")
            .cache()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .concatMap { repos -> poiRepositoryProvider.add(repos.poiList) }
    }
}