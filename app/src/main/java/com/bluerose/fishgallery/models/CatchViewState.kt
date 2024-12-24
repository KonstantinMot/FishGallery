package com.bluerose.fishgallery.models

import com.bluerose.fishgallery.data.local.entity.FishCatchDetails

sealed class CatchViewState{
    data object Loading:CatchViewState()
    data class Error(val description: String, val icon: Int):CatchViewState()
    data class Display(val fishCatchGallery:List<FishCatchDetails>):CatchViewState()
}