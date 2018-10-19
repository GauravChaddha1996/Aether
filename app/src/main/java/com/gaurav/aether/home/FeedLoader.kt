package com.gaurav.aether.home

import com.gaurav.aether.data.model.StoryItem

class FeedLoader {

    private var networkManager = NetworkManager()

    private var topStories: List<Long> = listOf()
    private var bestStories: List<Long> = listOf()
    private var newStories: List<Long> = listOf()
    private var showHnStories: List<Long> = listOf()
    private var askHnStories: List<Long> = listOf()
    private var jobStories: List<Long> = listOf()

    object LastIndexLoaded {
        var top: Int = -1
        var best: Int = -1
        var new: Int = -1
        var showHN: Int = -1
        var askHN: Int = -1
        var job: Int = -1
    }

    fun getNextStories(sort: SortOption):Int{

    }
}