package com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.renatoramos.rickandmorty.common.base.BaseFragment
import com.renatoramos.rickandmorty.episodes.R
import com.renatoramos.rickandmorty.episodes.databinding.FragmentEpisodesListBinding
import javax.inject.Inject

class EpisodesListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var episodesListViewModel: EpisodesListViewModel
    private lateinit var episodesListFragmentBinding: FragmentEpisodesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        episodesListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_episodes_list, container, false)

        // Inflate the layout for this fragment
        return episodesListFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        bindViewModel()
        //setupRecyclerView()
        //initialize()
        //getAllCharacters()
        //setObservables()
    }


    private fun bindViewModel() {
        episodesListViewModel =
            ViewModelProvider(activity!!, viewModelFactory).get(EpisodesListViewModel::class.java)


        episodesListFragmentBinding.let {
            it.lifecycleOwner = this
        }
    }




}
