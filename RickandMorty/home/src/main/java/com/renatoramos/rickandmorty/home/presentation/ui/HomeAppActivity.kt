package com.renatoramos.rickandmorty.home.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.renatoramos.rickandmorty.R
import com.renatoramos.rickandmorty.common.base.BaseActivity


class HomeAppActivity : BaseActivity() {

    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration.Builder(setOf(R.id.characters_list_fragment, R.id.episodes_list_fragment)).build()
    }

    private val navController: NavController by lazy { findNavController(R.id.fragment_nav_host) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setupActionBarWithNavController(){
        val tlbMain = findViewById<Toolbar>(R.id.tlb_main)
        setSupportActionBar(tlbMain)

        val btmNavMain = findViewById<BottomNavigationView>(R.id.btm_nav_main)

        btmNavMain.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.characters_list_fragment, R.id.episodes_list_fragment -> btmNavMain.visibility = View.VISIBLE
                else -> btmNavMain.visibility = View.GONE
            }
        }

    }
}