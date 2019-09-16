package com.renatoramos.common.extensions

import androidx.lifecycle.MutableLiveData
import com.renatoramos.common.util.LiveEvent

fun <T> MutableLiveData<T>.toSingleEvent(): MutableLiveData<T> {
    val result = LiveEvent<T>()
    result.addSource(this) {
        result.value = it
    }
    return result
}