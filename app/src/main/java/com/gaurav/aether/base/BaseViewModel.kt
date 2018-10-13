package com.gaurav.aether.base

interface BaseViewModel<in E : BaseView<*>> {
    fun attachView(view: E)
    fun detachView()
}