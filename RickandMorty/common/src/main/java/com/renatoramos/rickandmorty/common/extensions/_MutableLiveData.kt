package com.renatoramos.rickandmorty.common.extensions

import androidx.lifecycle.MutableLiveData
import com.renatoramos.rickandmorty.common.util.LiveEvent

fun <T> MutableLiveData<T>.toSingleEvent(): MutableLiveData<T> {
    val result = LiveEvent<T>()
    result.addSource(this) {
        result.value = it
    }
    return result
}