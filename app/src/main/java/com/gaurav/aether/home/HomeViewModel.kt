package com.gaurav.aether.home

import android.arch.lifecycle.ViewModel
import com.gaurav.aether.base.BaseViewModel
import io.reactivex.subjects.BehaviorSubject

class HomeViewModel : ViewModel(), BaseViewModel<HomeView> {

    var stateSubject: BehaviorSubject<HomeState> = BehaviorSubject.createDefault(HomeState())

    override fun attachView(view: HomeView) {
        bindIntents(view)
    }

    override fun detachView() {
        unbindIntents()
    }

    private fun bindIntents(view: HomeView) {

    }

    private fun unbindIntents() {

    }
}