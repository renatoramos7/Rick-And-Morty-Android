package com.renatoramos.rickandmorty.characters.presentation.ui.characterslist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.renatoramos.rickandmorty.characters.R
import com.renatoramos.rickandmorty.common.base.BaseFragment
import javax.inject.Inject


class CharactersListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var charactersListViewModel: CharactersListViewModel
    //private lateinit var charactersListFragmentBinding: CharactersListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {
        bindViewModel()
    }

    private fun bindViewModel() {
        charactersListViewModel = ViewModelProvider(activity!!, viewModelFactory).get(CharactersListViewModel::class.java)

        /*CharactersListFragmentBinding.let {
            it.vehicleListViewModelInView = charactersListViewModel
            it.lifecycleOwner = this
        }*/
    }


}
