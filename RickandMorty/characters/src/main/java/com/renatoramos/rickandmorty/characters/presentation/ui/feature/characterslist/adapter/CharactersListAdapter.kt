package com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter.holder.CharactersViewHolder
import com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter.holder.ListFooterViewHolder
import com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter.listener.CharactersListListener
import com.renatoramos.rickandmorty.common.util.State
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject

class CharactersListAdapter(
private val retry: () -> Unit,
private val charactersListListener: CharactersListListener
) : PagedListAdapter<CharacterViewObject, RecyclerView.ViewHolder>(characterViewObjectDiffCallback) {

    private val DATA_VIEW_TYPE = 1
    private val FOOTER_VIEW_TYPE = 2

    private var state = State.LOADING


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder

        if (viewType == DATA_VIEW_TYPE) {
            viewHolder = CharactersViewHolder.create(parent)
            //viewHolder.itemView.isLongClickable = true

           /* viewHolder.itemView.setOnLongClickListener {
                val CharacterViewObject = getItem(viewHolder.adapterPosition)

              *//*  charactersListListener.onItemLongClickRepo(
                    CharacterViewObject!!.htmlUrl!!,
                    CharacterViewObject.owner!!.htmlUrl!!
                )*//*


                true
            }*/
        } else {
            viewHolder = ListFooterViewHolder.create(retry, parent)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == DATA_VIEW_TYPE)
            (holder as CharactersViewHolder).bind(getItem(position))
        else (holder as ListFooterViewHolder).bind(state)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) DATA_VIEW_TYPE else FOOTER_VIEW_TYPE
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1 else 0
    }

    private fun hasFooter(): Boolean {
        return super.getItemCount() != 0 && (state == State.LOADING || state == State.ERROR)
    }

    fun setState(state: State) {
        this.state = state
        notifyDataSetChanged()
    }

    companion object {
        val characterViewObjectDiffCallback = object : DiffUtil.ItemCallback<CharacterViewObject>() {
            override fun areItemsTheSame(oldItem: CharacterViewObject, newItem: CharacterViewObject): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterViewObject, newItem: CharacterViewObject): Boolean {
                return oldItem == newItem
            }
        }
    }
}