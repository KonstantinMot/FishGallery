package com.bluerose.fishgallery.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bluerose.fishgallery.ui.screens.catch.CatchScreen
import com.bluerose.fishgallery.ui.screens.statistics.StatisticsScreen

@Composable
fun NavHostScreen(){
    val navController = rememberNavController()
   NavHost(navController=navController, startDestination =NavScreen.Statistics ){

      composable<NavScreen.Statistics>{ StatisticsScreen(navController=navController)}
      composable<NavScreen.Catch>{ CatchScreen(navController=navController) }
    }
}