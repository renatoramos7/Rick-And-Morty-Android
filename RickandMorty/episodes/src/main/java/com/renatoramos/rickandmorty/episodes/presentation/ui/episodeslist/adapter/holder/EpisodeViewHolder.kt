package com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.renatoramos.rickandmorty.domain.viewobject.episodes.EpisodeViewObject
import com.renatoramos.rickandmorty.episodes.R
import kotlinx.android.synthetic.main.episodes_viewholder.view.*

class EpisodeViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    fun bind(episodeViewObject: EpisodeViewObject?) {
        episodeViewObject?.let {
            itemView.repoNameTextView.text = episodeViewObject.episode
            itemView.description.text = episodeViewObject.name
            itemView.loginOwneTextView.text = episodeViewObject.airDate
        }
    }

    companion object {
        fun create(parent: ViewGroup): EpisodeViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.episodes_viewholder, parent, false)
            return EpisodeViewHolder(view)
        }
    }
}