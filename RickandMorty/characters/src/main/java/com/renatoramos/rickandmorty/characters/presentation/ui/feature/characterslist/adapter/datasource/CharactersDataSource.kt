package com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.renatoramos.rickandmorty.common.util.State
import com.renatoramos.rickandmorty.domain.usecases.characters.CharactersUseCase
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.schedulers.Schedulers


class CharactersDataSource(
    private val compositeDisposable: CompositeDisposable,
    private val charactersUseCase: CharactersUseCase
) : PageKeyedDataSource<Int, CharacterViewObject>() {

    var state: MutableLiveData<State> = MutableLiveData()
    private var retryCompletable: Completable? = null

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, CharacterViewObject>) {
        updateState(State.LOADING)
        compositeDisposable.add(
            charactersUseCase.requestAllCharacters(1)
                .subscribe(
                    { response ->
                        updateState(State.DONE)
                        callback.onResult(
                            response,
                            null,
                            2
                        )
                    },
                    {
                        updateState(State.ERROR)
                        setRetry(Action { loadInitial(params, callback) })
                    }
                )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterViewObject>) {
        updateState(State.LOADING)

        compositeDisposable.add(
            charactersUseCase.requestAllCharacters(params.key)
                .subscribe(
                    { response ->
                        updateState(State.DONE)
                        callback.onResult(
                            response,
                            params.key + 1
                        )
                    },
                    {
                        updateState(State.ERROR)
                        setRetry(Action { loadAfter(params, callback) })
                    }
                )
        )


    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterViewObject>) {}

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