package com.renatoramos.rickandmorty.domain.data.store.repository.episodes

import com.renatoramos.rickandmorty.domain.data.store.local.paperdb.provider.BaseRepositoryProvider
import com.renatoramos.rickandmorty.domain.data.store.remote.retrofit.api.episodes.EpisodesApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val episodesApi: EpisodesApi,
    private val baseRepositoryProvider: BaseRepositoryProvider
) {

    private val TAGKEY = EpisodesRepository::class.java.simpleName

    fun requestRepositories(page: Int): @NonNull Maybe<List<Any>>? {
        val remote = getAllEpisodesRemote(page)
        val local = getAllEpisodesLocal(page)

        return Observable.concatArrayDelayError(remote, local)
            .filter { list -> list != null }
            .firstElement()
    }

    /* Local Part */
    private fun getAllEpisodesLocal(page: Int): Observable<List<Any>> {
        return baseRepositoryProvider.getAll(TAGKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /* Remote Part */
    private fun getAllEpisodesRemote(page: Int): Observable<List<Any>> {
        return episodesApi.getAllEpisodes(page)
            .cache()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .concatMap { repos -> baseRepositoryProvider.add(repos, TAGKEY) }
    }


}