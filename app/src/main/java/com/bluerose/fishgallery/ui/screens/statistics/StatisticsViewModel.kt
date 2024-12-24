package com.bluerose.fishgallery.ui.screens.statistics
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluerose.fishgallery.data.local.repository.StatisticsRepository
import com.bluerose.fishgallery.models.StatisticsAction
import com.bluerose.fishgallery.models.StatisticsEvent
import com.bluerose.fishgallery.models.StatisticsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okio.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel@Inject constructor(private val repository: StatisticsRepository) : ViewModel() {
    private val _state = mutableStateOf<StatisticsViewState>(StatisticsViewState.Loading)
    val state = _state
    private val _actions = mutableStateOf<StatisticsAction?>(null)
    val actions = _actions

    init {
        onEvent(StatisticsEvent.EnterScreen)

    }

    fun onEvent(event: StatisticsEvent) {
        when (event) {
            StatisticsEvent.EnterScreen -> loadStatistics()

            StatisticsEvent.ReloadScreen -> loadStatistics()
            StatisticsEvent.ShowContacts -> {
                _actions.value = StatisticsAction.ShowDialog(
                    title = "Контакты компании",
                    message = "Адрес: ул. Примерная, д. 1\nТелефон: +7 (123) 456-78-90",
                    buttonText = "ОК"
                )
            }

            else -> {}
        }
    }

    fun clearAction() {
        _actions.value = null
    }

    private fun loadStatistics() {
        viewModelScope.launch {
            try {
                _state.value = StatisticsViewState.Loading
                delay(2000)
                val commonStats = repository.getCommonStatistics()
                _state.value = StatisticsViewState.Display(
                    fishCatch = commonStats.fishCatch,
                    profit = commonStats.profit,
                    partners = commonStats.partnerCount
                )

            } catch (e: Exception) {
                val errorMessage = when (e) {
                    is IOException -> "Не удалось загрузить статистику.\n Проверьте ваше интернет-соединение."
                    is TimeoutException -> "Ошибка загрузки: время ожидания истекло.\n Пожалуйста, повторите попытку."

                    else -> "Произошла ошибка.\n Попробуйте еще раз позже."
                }

                _state.value = StatisticsViewState.Error(
                    description = errorMessage, icon = 2
                )
            }
        }
    }


}