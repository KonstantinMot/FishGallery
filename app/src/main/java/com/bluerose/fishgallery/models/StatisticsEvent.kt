package com.bluerose.fishgallery.models

import com.bluerose.fishgallery.ui.navigation.NavScreen

sealed class StatisticsEvent {
    data object EnterScreen:StatisticsEvent()
    data object ReloadScreen:StatisticsEvent()
    data class OpenScreen(val destination: NavScreen) : StatisticsEvent()
    data object ShowContacts:StatisticsEvent()

}