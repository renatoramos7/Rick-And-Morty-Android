package com.renatoramos.rickandmorty.home.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.renatoramos.rickandmorty.R
import com.renatoramos.rickandmorty.common.base.BaseActivity
import com.renatoramos.rickandmorty.databinding.ActivityMainBinding
import javax.inject.Inject


class HomeAppActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var homeAppViewModel: HomeAppViewModel
    private lateinit var homeAppActivityBinding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var homeToolbar : Toolbar
    private lateinit var homeBottomNavigationView : BottomNavigationView

    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration.Builder(setOf(R.id.characters_list_fragment, R.id.episodes_list_fragment)).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeAppActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun initView() {
        bindViewModel()
        setUiComponents()
        setupActionBarWithNavController()
    }

    private fun bindViewModel() {
        homeAppViewModel = ViewModelProvider(this, viewModelFactory).get(
            HomeAppViewModel::class.java)

       homeAppActivityBinding.let {
            it.lifecycleOwner = this
        }
    }

    private fun setUiComponents() {
        homeToolbar = homeAppActivityBinding.homeToolbar
        homeBottomNavigationView = homeAppActivityBinding.btmNavMain
        navController = findNavController(R.id.fragment_nav_host)
    }

    private fun setupActionBarWithNavController(){
        setSupportActionBar(homeToolbar)
        homeBottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.characters_list_fragment,
                R.id.episodes_list_fragment ->
                    homeBottomNavigationView.visibility = View.VISIBLE
                else -> homeBottomNavigationView.visibility = View.GONE
            }
        }

    }
}