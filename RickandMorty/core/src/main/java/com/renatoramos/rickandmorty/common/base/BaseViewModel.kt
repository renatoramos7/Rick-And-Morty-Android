package com.renatoramos.rickandmorty.common.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel() {

    private var compositeDisposable: CompositeDisposable? = null

    /**
     * Contains common cleanup actions needed for all ViewModel, if any.
     * Subclasses may override this.
     */
    fun onStopDisposable() {
        getCompositeDisposable().clear()
    }

    protected fun addDisposable(disposable: Disposable) {
        getCompositeDisposable().add(disposable)
    }

    protected fun getCompositeDisposable(): CompositeDisposable {
        if (compositeDisposable == null || compositeDisposable!!.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
        return compositeDisposable as CompositeDisposable
    }
}