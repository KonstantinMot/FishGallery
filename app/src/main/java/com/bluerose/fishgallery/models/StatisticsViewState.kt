package com.bluerose.fishgallery.models

sealed class StatisticsViewState {
    data object Loading : StatisticsViewState()
    data class Error(val description: String, val icon: Int) : StatisticsViewState()
    data class Display(val fishCatch: Long, val profit: Double, val partners: Int) : StatisticsViewState()
}