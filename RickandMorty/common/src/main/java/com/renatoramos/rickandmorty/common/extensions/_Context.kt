package com.renatoramos.rickandmorty.common.extensions

import android.content.Context
import android.widget.Toast


/**
 * Method to create and Show a Toast Message in the view.
 */
fun Context.makeTextToast(toastText: CharSequence, duration: Int): Toast {
    return Toast.makeText(this, toastText, duration)
}

