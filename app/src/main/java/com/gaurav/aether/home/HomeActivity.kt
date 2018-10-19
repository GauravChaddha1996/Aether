package com.gaurav.aether.home

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gaurav.aether.R

class HomeActivity : AppCompatActivity(), HomeView {

    override lateinit var viewModel: HomeViewModel
    override lateinit var sortOption: SortOption

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        sortOption = Top()
        lifecycle.addObserver(this)
    }

    override fun render(state: HomeState) {
        Log.d("State rendered", state.toString())
    }

}
