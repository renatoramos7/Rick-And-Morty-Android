package com.renatoramos.rickandmorty.common.extensions

import android.widget.ImageView
import com.renatoramos.rickandmorty.common.modular.di.module.GlideApp
import com.renatoramos.rickandmorty.common.ui.components.DrawableRequestListener



fun ImageView.loadWithGlide(url: String) {
    GlideApp.with(context).load(url).into(this)
}

fun ImageView.loadWithGlide(url: String, listener: DrawableRequestListener) {
    GlideApp.with(context).load(url).listener(listener).into(this)
}
