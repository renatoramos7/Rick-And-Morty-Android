package com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.renatoramos.rickandmorty.common.base.BaseFragment
import com.renatoramos.rickandmorty.common.util.State
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
        setupRecyclerView()
        initialize()
        getAllEpisodes()
        setObservables()
    }


    private fun bindViewModel() {
        episodesListViewModel =
            ViewModelProvider(activity!!, viewModelFactory).get(EpisodesListViewModel::class.java)


        episodesListFragmentBinding.let {
            it.lifecycleOwner = this
        }
    }

    private fun setObservables() {
        episodesListViewModel.getState().observe(viewLifecycleOwner, Observer { state ->
            episodesListFragmentBinding.progressBar.visibility =
                if (episodesListViewModel.listIsEmpty() && state == State.LOADING) View.VISIBLE else View.GONE
            episodesListFragmentBinding.txtError.visibility =
                if (episodesListViewModel.listIsEmpty() && state == State.ERROR) View.VISIBLE else View.GONE
            if (!episodesListViewModel.listIsEmpty()) {
                charactersListAdapter.setState(state ?: State.DONE)
            }
        })

        episodesListViewModel.reposListLiveData.observe(viewLifecycleOwner, Observer {
            charactersListAdapter.submitList(it)
        })
    }

    private fun initialize() {
        episodesListFragmentBinding.txtError.setOnClickListener { episodesListViewModel.retry() }
    }

    private fun setupRecyclerView() {
        episodesListFragmentBinding.episodesRecyclerView.layoutManager = LinearLayoutManager(activity?.baseContext)
        episodesListFragmentBinding.episodesRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        episodesListFragmentBinding.episodesRecyclerView.setHasFixedSize(true)


        charactersListAdapter = CharactersListAdapter(
            { episodesListViewModel.retry() },
            this
        )

        episodesListFragmentBinding.episodesRecyclerView.adapter = charactersListAdapter
    }

    private fun getAllEpisodes() {
        episodesListViewModel.getAllEpisodes()
    }

}