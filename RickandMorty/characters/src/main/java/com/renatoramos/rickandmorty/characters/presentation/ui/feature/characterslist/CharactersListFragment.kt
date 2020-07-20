package com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.renatoramos.rickandmorty.characters.R
import com.renatoramos.rickandmorty.characters.databinding.FragmentCharactersListBinding
import com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter.CharactersListAdapter
import com.renatoramos.rickandmorty.characters.presentation.ui.feature.characterslist.adapter.listener.CharactersListListener
import com.renatoramos.rickandmorty.common.base.BaseFragment
import com.renatoramos.rickandmorty.common.extensions.makeTextToast
import com.renatoramos.rickandmorty.common.util.State
import javax.inject.Inject

class CharactersListFragment : BaseFragment(), CharactersListListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var charactersListViewModel: CharactersListViewModel
    private lateinit var charactersListFragmentBinding: FragmentCharactersListBinding
    private lateinit var charactersListAdapter: CharactersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        charactersListFragmentBinding = FragmentCharactersListBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return charactersListFragmentBinding.root
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
        getAllCharacters()
        setObservables()
    }

    private fun bindViewModel() {
        charactersListViewModel =
            ViewModelProvider(activity!!, viewModelFactory).get(CharactersListViewModel::class.java)
    }

    private fun setObservables() {
        charactersListViewModel.getState().observe(viewLifecycleOwner, Observer { state ->
            charactersListFragmentBinding.progressBar.visibility =
                if (charactersListViewModel.listIsEmpty() && state == State.LOADING) View.VISIBLE else View.GONE
            charactersListFragmentBinding.txtError.visibility =
                if (charactersListViewModel.listIsEmpty() && state == State.ERROR) View.VISIBLE else View.GONE
            if (!charactersListViewModel.listIsEmpty()) {
                charactersListAdapter.setState(state ?: State.DONE)
            }
        })

        charactersListViewModel.reposListLiveData.observe(viewLifecycleOwner, Observer {
            charactersListAdapter.submitList(it)
        })
    }

    private fun initialize() {
        charactersListFragmentBinding.txtError.setOnClickListener { charactersListViewModel.retry() }
    }

    private fun setupRecyclerView() {
        charactersListFragmentBinding.charactersRecyclerView.layoutManager =
            LinearLayoutManager(activity?.baseContext)
        charactersListFragmentBinding.charactersRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        charactersListFragmentBinding.charactersRecyclerView.setHasFixedSize(true)


        charactersListAdapter = CharactersListAdapter(
            { charactersListViewModel.retry() },
            this
        )

        charactersListFragmentBinding.charactersRecyclerView.adapter = charactersListAdapter
    }

    private fun getAllCharacters() {
        charactersListViewModel.getAllCharacters()
    }

}
