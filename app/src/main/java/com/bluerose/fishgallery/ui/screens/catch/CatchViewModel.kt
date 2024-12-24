package com.bluerose.fishgallery.ui.screens.catch
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluerose.fishgallery.data.local.repository.StatisticsRepository
import com.bluerose.fishgallery.models.CatchEvent
import com.bluerose.fishgallery.models.CatchViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okio.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject


@HiltViewModel
 class CatchViewModel@Inject constructor(private val repository: StatisticsRepository) :
    ViewModel() {
    private val _state = mutableStateOf<CatchViewState>(CatchViewState.Loading)
    val state = _state
    private var isLoading = false
    init {
        onEvent(CatchEvent.EnterScreen)
    }

    fun onEvent(event: CatchEvent) {
        when (event) {
            CatchEvent.EnterScreen -> if (!isLoading) {
                _state.value = CatchViewState.Loading
                loadStatistics()

            }

            CatchEvent.ReloadScreen -> if (!isLoading) loadStatistics()

            else -> {}
        }
    }

    private fun loadStatistics() {
        isLoading = true
        viewModelScope.launch {
            try {
                _state.value = CatchViewState.Loading
                delay(2000)
                val fishCatchState = repository.getFishCatchStatistics()
                _state.value = CatchViewState.Display(fishCatchGallery = fishCatchState)

            } catch (e: Exception) {
                val errorMessage = when (e) {
                    is IOException -> "Не удалось загрузить статистику.\n Проверьте ваше интернет-соединение."
                    is TimeoutException -> "Ошибка загрузки: время ожидания истекло.\n Пожалуйста, повторите попытку."

                    else -> "Произошла ошибка.\n Попробуйте еще раз позже."
                }

                _state.value = CatchViewState.Error(
                    description = errorMessage, icon = 2
                )
            } finally {
                isLoading = false
            }


        }


    }
}