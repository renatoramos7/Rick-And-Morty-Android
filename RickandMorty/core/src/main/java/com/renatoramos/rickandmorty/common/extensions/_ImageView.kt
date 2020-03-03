package com.renatoramos.rickandmorty.common.extensions

import androidx.appcompat.widget.AppCompatImageView
import com.renatoramos.rickandmorty.common.modular.di.module.GlideApp
import com.renatoramos.rickandmorty.common.ui.components.DrawableRequestListener



fun AppCompatImageView.loadWithGlide(url: String) {
    GlideApp.with(context).load(url).into(this)
}

fun AppCompatImageView.loadWithGlide(url: String, listener: DrawableRequestListener) {
    GlideApp.with(context).load(url).listener(listener).into(this)
}
