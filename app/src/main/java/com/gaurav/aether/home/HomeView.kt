package com.gaurav.aether.home

import com.gaurav.aether.base.BaseView

interface HomeView : BaseView<HomeState> {
    var viewModel: HomeViewModel

    override fun attachView() {
        viewModel.attachView(this)
    }

    override fun detachView() {
        viewModel.detachView()
    }

    override fun render(state: HomeState)
}