package com.bluerose.fishgallery.di

import com.bluerose.fishgallery.data.local.entity.FishCatchDetails
import com.bluerose.fishgallery.data.local.entity.StatisticsDetails
import com.bluerose.fishgallery.data.local.repository.StatisticsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideStatisticsRepository():StatisticsRepository{
return StatisticsRepository()
    }

}