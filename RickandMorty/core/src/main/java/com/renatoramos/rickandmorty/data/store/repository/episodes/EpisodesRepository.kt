package com.renatoramos.rickandmorty.data.store.repository.episodes

import com.renatoramos.rickandmorty.data.store.remote.retrofit.api.episodes.EpisodesApi
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val episodesApi: EpisodesApi
) {

    /*private val TAGKEY = EpisodesRepository::class.java.simpleName

    fun requestRepositories(page: Int): @NonNull Maybe<List<Any>>? {
        val remote = getAllEpisodesRemote(page)
        val local = getAllEpisodesLocal(page)

        return Observable.concatArrayDelayError(remote, local)
            .filter { list -> list != null }
            .firstElement()
    }

    *//* Local Part *//*
    private fun getAllEpisodesLocal(page: Int): Observable<List<Any>> {
        return characterProvider.getAll(page, TAGKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    *//* Remote Part *//*
    private fun getAllEpisodesRemote(page: Int): Observable<List<Any>> {
        return episodesApi.getAllEpisodes(page)
            .cache()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .concatMap { repos -> characterProvider.add(repos, TAGKEY) }
    }*/


}