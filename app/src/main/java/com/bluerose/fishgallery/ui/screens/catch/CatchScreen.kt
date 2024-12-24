package com.bluerose.fishgallery.ui.screens.catch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bluerose.fishgallery.models.CatchEvent
import com.bluerose.fishgallery.models.CatchViewState
import com.bluerose.fishgallery.ui.screens.catch.views.CatchViewDisplay


@Composable
fun CatchScreen(navController: NavController, viewModel:CatchViewModel= hiltViewModel()) {

    val viewState by viewModel.state
    when (val state = viewState) {
                CatchViewState.Loading -> {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.primary)){
                    CircularProgressIndicator(
                        Modifier
                            .fillMaxSize()
                            .align(Alignment.Center), color = Color.Red)
                }}
                is CatchViewState.Display -> CatchViewDisplay(state) { event ->
                    when (event) {
                        CatchEvent.CloseScreen -> navController.navigateUp()
                        else -> {
                            viewModel.onEvent(event)
                        }
                    }


                }

                is CatchViewState.Error -> {}
                }
            }





