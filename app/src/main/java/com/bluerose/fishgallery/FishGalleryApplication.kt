package com.bluerose.fishgallery

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FishGalleryApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}