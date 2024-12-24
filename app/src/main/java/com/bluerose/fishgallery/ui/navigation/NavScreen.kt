package com.bluerose.fishgallery.ui.navigation

import kotlinx.serialization.Serializable
@Serializable
sealed class NavScreen(){
@Serializable
data object Statistics:NavScreen()
@Serializable
data object Catch:NavScreen()}
