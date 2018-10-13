package com.gaurav.aether.home

import com.gaurav.aether.data.model.StoryItem

data class HomeState(val loadingFirstPage: Boolean = false,
                     val firstPageError: Throwable? = null,
                     val loadingNextPage: Boolean = false,
                     val nextPageError: Throwable? = null,
                     val refreshingPage: Boolean = false,
                     val refreshPageError: Throwable? = null,
                     val result: List<StoryItem> = listOf()
) {
    fun isEmpty(): Boolean {
        return !loadingFirstPage && !loadingNextPage && !refreshingPage && result.isEmpty()
    }
}