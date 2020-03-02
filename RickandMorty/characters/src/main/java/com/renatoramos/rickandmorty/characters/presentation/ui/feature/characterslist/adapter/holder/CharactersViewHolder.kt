package com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.renatoramos.rickandmorty.characters.R
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject

class CharactersViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    fun bind(characterViewObject: CharacterViewObject?) {
        characterViewObject?.let {
         /*   itemView.repoNameTextView.text = it.name
            itemView.description.text = it.description
            itemView.loginOwneTextView.text = it.owner!!.login

            if (it.fork!!)
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.white))
            else
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.lightgreen))*/
        }
    }

    companion object {
        fun create(parent: ViewGroup): CharactersViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repo, parent, false)
            return CharactersViewHolder(view)
        }
    }
}