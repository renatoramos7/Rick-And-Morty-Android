package com.renatoramos.rickandmorty.presentation.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.renatoramos.rickandmorty.common.base.BaseActivity
import com.renatoramos.rickandmorty.R

class MainAppActivity : BaseActivity() {

    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navigationController)
    }

    override fun onSupportNavigateUp() = navigationController.navigateUp()
}
