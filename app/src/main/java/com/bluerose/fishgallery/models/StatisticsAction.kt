package com.bluerose.fishgallery.models

sealed class StatisticsAction{
    data class ShowDialog(val title: String,
                          val message: String,
                          val buttonText: String
    ) : StatisticsAction()
}