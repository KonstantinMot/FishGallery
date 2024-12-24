package com.bluerose.fishgallery.ui.screens.statistics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bluerose.fishgallery.models.StatisticsAction
import com.bluerose.fishgallery.models.StatisticsEvent
import com.bluerose.fishgallery.models.StatisticsViewState
import com.bluerose.fishgallery.ui.screens.statistics.views.StatisticsViewDisplay
import com.bluerose.fishgallery.ui.theme.components.JetDialog

@Composable
fun StatisticsScreen(navController: NavController, viewModel: StatisticsViewModel= hiltViewModel()) {
    val viewAction by viewModel.actions
    val viewSate by viewModel.state
    when (val action = viewAction) {
        is StatisticsAction.ShowDialog -> {
            Box(Modifier.fillMaxSize()) {
            JetDialog(action.title, action.message, action.buttonText) { viewModel.clearAction() }
        }}

        else -> {}
    }
    when (val state = viewSate) {
        StatisticsViewState.Loading->{ Box(modifier = Modifier.fillMaxSize().background(
            MaterialTheme.colorScheme.primary)){
            CircularProgressIndicator(Modifier.fillMaxSize().align(Alignment.Center))
        }

        }
        is StatisticsViewState.Display -> {
            StatisticsViewDisplay(state) { event ->
                when (event) {
                    is StatisticsEvent.OpenScreen -> {
                        navController.navigate(event.destination)
                    }
                    else->{viewModel.onEvent(event=event)}
                }
            }
        }

        is StatisticsViewState.Error -> TODO()
        StatisticsViewState.Loading -> TODO()
    }



    }


