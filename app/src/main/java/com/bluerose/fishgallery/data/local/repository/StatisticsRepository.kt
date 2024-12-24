package com.bluerose.fishgallery.data.local.repository

import com.bluerose.fishgallery.data.local.entity.FishCatchDetails
import com.bluerose.fishgallery.data.local.entity.StatisticsDetails

class StatisticsRepository(){
    fun getCommonStatistics():StatisticsDetails{
        return StatisticsDetails(profit = 1.08E8, fishCatch = 5400000, partnerCount = 1500)
    }
    fun getFishCatchStatistics():List<FishCatchDetails>{
        return listOf(FishCatchDetails(fishName = "Призрачный дельфи", fishCatch = 50000000, imagePath = "file:///android_asset/Fish1.jpg"),
           FishCatchDetails("Алмазный ус",48000000,"file:///android_asset/Fish2.jpg"),
            FishCatchDetails("Шестиперая аку",10000000,"file:///android_asset/Fish3.jpg") )
    }
}