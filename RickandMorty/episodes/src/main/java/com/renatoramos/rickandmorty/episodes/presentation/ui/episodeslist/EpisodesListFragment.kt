package com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renatoramos.rickandmorty.common.base.BaseFragment
import com.renatoramos.rickandmorty.common.extensions.makeTextToast
import com.renatoramos.rickandmorty.common.util.State
import com.renatoramos.rickandmorty.episodes.databinding.FragmentEpisodesListBinding
import com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist.adapter.EpisodesListAdapter
import com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist.adapter.listener.EpisodesListListener
import javax.inject.Inject

class EpisodesListFragment : BaseFragment(), EpisodesListListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var episodesListViewModel: EpisodesListViewModel
    private lateinit var episodesListFragmentBinding: FragmentEpisodesListBinding
    private lateinit var episodesListAdapter: EpisodesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        episodesListFragmentBinding = FragmentEpisodesListBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return episodesListFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onItemClick(anyString: String) {
        context?.makeTextToast(anyString, Toast.LENGTH_LONG)?.show()
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
    }

    private fun setObservables() {
        episodesListViewModel.getState().observe(viewLifecycleOwner, { state ->
            episodesListFragmentBinding.progressBar.visibility =
                if (episodesListViewModel.listIsEmpty() && state == State.LOADING) View.VISIBLE else View.GONE
            episodesListFragmentBinding.txtError.visibility =
                if (episodesListViewModel.listIsEmpty() && state == State.ERROR) View.VISIBLE else View.GONE
            if (!episodesListViewModel.listIsEmpty()) {
                episodesListAdapter.setState(state ?: State.DONE)
            }
        })

        episodesListViewModel.reposListLiveData.observe(viewLifecycleOwner, {
            episodesListAdapter.submitList(it)
        })
    }

    private fun initialize() {
        episodesListFragmentBinding.txtError.setOnClickListener { episodesListViewModel.retry() }
    }

    private fun setupRecyclerView() {
        episodesListFragmentBinding.episodesRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        episodesListFragmentBinding.episodesRecyclerView.setHasFixedSize(true)

        episodesListAdapter = EpisodesListAdapter(
            { episodesListViewModel.retry() },
            this
        )

        episodesListFragmentBinding.episodesRecyclerView.adapter = episodesListAdapter
    }

    private fun getAllEpisodes() {
        episodesListViewModel.getAllEpisodes()
    }

}