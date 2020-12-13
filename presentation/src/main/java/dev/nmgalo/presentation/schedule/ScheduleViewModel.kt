package dev.nmgalo.presentation.schedule

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.nmgalo.domain.schedule.model.TimeTableData
import dev.nmgalo.domain.schedule.usecase.GetScheduleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ScheduleViewModel @ViewModelInject constructor(
    private val scheduleUseCase: GetScheduleUseCase
) : ViewModel() {

    val schedules = MutableLiveData<List<ScheduleUIModel>>()

    init {
        getSchedulesList()
    }

    private fun getSchedulesList() {
        viewModelScope.launch(Dispatchers.IO) {
            scheduleUseCase.get().collect { scheduleResult ->
                schedules.postValue(
                    scheduleResult.map { item -> item.toUIModel() }
                )
            }
        }
    }

    private fun TimeTableData.toUIModel(): ScheduleUIModel =
        ScheduleUIModel(
            tableData = this,
            onClick = {}
        )

}