package com.bluerose.fishgallery.models

sealed class CatchAction{
    data class ShowDialog(val title: String,
                          val message: String,
                          val buttonText: String
    ) : CatchAction()
}