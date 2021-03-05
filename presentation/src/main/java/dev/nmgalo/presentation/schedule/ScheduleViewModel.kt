package dev.nmgalo.presentation.schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nmgalo.domain.schedule.usecase.GetScheduleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleUseCase: GetScheduleUseCase
) : ViewModel() {

    val schedules = MutableLiveData<List<ScheduleUIModel>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getSchedulesList()
        }
    }

    private suspend fun getSchedulesList() {
        scheduleUseCase.get().collect { scheduleResult ->
            schedules.postValue(scheduleResult.map {
                ScheduleUIModel(
                    it,
                    onClick = {
                        android.util.Log.d("onScheduleItemClick", it.TrainName)
                    }
                )
            })
        }

    }

}
