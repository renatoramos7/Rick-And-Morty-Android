package com.renatoramos.rickandmorty.data.store.remote.retrofit.repository.poi

import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.BaseRepositoryProvider
import com.renatoramos.rickandmorty.data.store.remote.retrofit.service.poi.PoiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PoiRepository @Inject constructor(
    private val reposService: PoiService,
    private val baseRepositoryProvider: BaseRepositoryProvider
) {
    private val TAGKEY = PoiRepository::class.java.simpleName

    fun requestRepositories(): Maybe<List<Any>> {
        val remote = getRepositoriesRemote()
        val local = getRepositoriesLocal()

        return Observable.concatArrayDelayError(remote, local)
            .filter { list -> list != null }
            .firstElement()
    }

    /* Local Part */
    private fun getRepositoriesLocal(): Observable<List<Any>> {
        return baseRepositoryProvider.getAll(TAGKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /* Remote Part */
    private fun getRepositoriesRemote(): Observable<List<Any>> {
        return reposService.requestPoiList(
            "53.694865",
            "9.757589",
            "53.394655",
            "10.099891")
            .cache()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .concatMap { repos -> baseRepositoryProvider.add(repos.poiList, TAGKEY) }
    }
}