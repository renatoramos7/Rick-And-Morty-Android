package com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter.holder

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.renatoramos.rickandmorty.characters.R
import com.renatoramos.rickandmorty.common.extensions.loadWithGlide
import com.renatoramos.rickandmorty.common.ui.components.DrawableRequestListener
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
import kotlinx.android.synthetic.main.item_repo.view.*

class CharactersViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    fun bind(characterViewObject: CharacterViewObject?) {
        characterViewObject?.let {
            itemView.titleTextView.text = it.name
            setupImageView(it.image)
        }
    }

    private fun setupImageView( url: String) {
        itemView.placeGuideImageView.loadWithGlide(url, object : DrawableRequestListener() {
            override fun onResourceReady(bitmap: Bitmap){
                itemView.placeGuideImageView.setRatio(bitmap.width.toFloat() / bitmap.height)
            }
        })
    }

    companion object {
        fun create(parent: ViewGroup): CharactersViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repo, parent, false)
            return CharactersViewHolder(view)
        }
    }
}