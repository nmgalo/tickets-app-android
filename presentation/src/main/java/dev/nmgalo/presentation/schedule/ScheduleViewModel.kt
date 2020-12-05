package dev.nmgalo.presentation.schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScheduleViewModel : ViewModel() {

    val schedules = MutableLiveData<List<ScheduleUiModel>>()

    init {
        schedules.postValue(
            listOf(
                ScheduleUiModel(1, "Nick mgaloba", {}),
                ScheduleUiModel(2, "Jemala chkuaseli", {}),
            )
        )
    }

}