package com.gaurav.aether.home

import com.gaurav.aether.data.model.StoryItem
import io.reactivex.Single

class NetworkManager {

    fun fetchTopStories(): Single<List<StoryItem>> {
        return Single.fromCallable { listOf(StoryItem("title2", "site2", "time2", 10, 10)) }
    }

}