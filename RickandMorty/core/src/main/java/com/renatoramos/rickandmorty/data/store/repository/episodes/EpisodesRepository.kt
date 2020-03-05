package com.renatoramos.rickandmorty.data.store.repository.episodes

import androidx.annotation.NonNull
import com.renatoramos.rickandmorty.data.store.dto.episodes.EpisodeDTO
import com.renatoramos.rickandmorty.data.store.local.paperdb.provider.episodes.EpisodesProvider
import com.renatoramos.rickandmorty.data.store.remote.retrofit.api.episodes.EpisodesApi
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val episodesApi: EpisodesApi,
    private val episodesProvider: EpisodesProvider
) {
    private val TAGKEY = EpisodesRepository::class.java.simpleName

    fun requestAllEpisodes(page: Int):  Maybe<List<EpisodeDTO>> {
        val remote = getAllEpisodesRemote(page)
        val local = getAllEpisodesLocal(page)

        return Observable.concatArrayDelayError(remote, local)
            .filter { list -> list != null }
            .firstElement()
    }

    //* Local Part *//*
    private fun getAllEpisodesLocal(page: Int): Observable<List<EpisodeDTO>> {
        return episodesProvider.getAll(page, TAGKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    //* Remote Part *//*
    private fun getAllEpisodesRemote(page: Int): Observable<List<EpisodeDTO>> {
        return episodesApi.getAllEpisodes(page)
            .cache()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .concatMap { repos -> episodesProvider.add(repos, page, TAGKEY) }
    }

}