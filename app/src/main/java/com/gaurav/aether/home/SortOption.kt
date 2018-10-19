package com.gaurav.aether.home

sealed class SortOption
class Top : SortOption()
class Best : SortOption()
class New : SortOption()
class ShowHN : SortOption()
class Jobs : SortOption()
