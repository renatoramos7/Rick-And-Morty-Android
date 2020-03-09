package com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist.adapter.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.renatoramos.rickandmorty.common.util.State
import com.renatoramos.rickandmorty.domain.usecases.episodes.EpisodesUseCase
import com.renatoramos.rickandmorty.domain.viewobject.episodes.EpisodeViewObject
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers

class EpisodesDataSource(
    private val compositeDisposable: CompositeDisposable,
    private val episodesUseCase: EpisodesUseCase
) : PageKeyedDataSource<Int, EpisodeViewObject>() {

    var state: MutableLiveData<State> = MutableLiveData()
    private var retryCompletable: Completable? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, EpisodeViewObject>
    ) {
        updateState(State.LOADING)
        compositeDisposable.add(
            episodesUseCase.requestAllEpisodes(1)
                .subscribe(
                    { response ->
                        updateState(State.DONE)
                        callback.onResult(
                            response,
                            null,
                            2
                        )
                    }, {
                        updateState(State.ERROR)
                        setRetry(Action { loadInitial(params, callback) })
                    }
                )
        )
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, EpisodeViewObject>
    ) {
        updateState(State.LOADING)
        compositeDisposable.add(
            episodesUseCase.requestAllEpisodes(params.key)
                .subscribe(
                    { response ->
                        updateState(State.DONE)
                        callback.onResult(
                            response,
                            params.key + 1
                        )
                    }, {
                        updateState(State.ERROR)
                        setRetry(Action { loadAfter(params, callback) })
                    }
                )
        )
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, EpisodeViewObject>
    ) {
    }

    private fun updateState(state: State) {
        this.state.postValue(state)
    }

    fun retry() {
        if (retryCompletable != null) {
            compositeDisposable.add(
                retryCompletable!!
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            )
        }
    }

    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }
}