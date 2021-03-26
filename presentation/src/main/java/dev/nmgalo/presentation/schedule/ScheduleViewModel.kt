package dev.nmgalo.presentation.schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nmgalo.domain.schedule.usecase.GetScheduleUseCase
import dev.nmgalo.presentation.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleUseCase: GetScheduleUseCase
) : BaseViewModel() {

    val schedules = MutableLiveData<List<ScheduleUIModel>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getSchedulesList()
        }
    }

    private suspend fun getSchedulesList() {
        scheduleUseCase.get().collect { scheduleResult ->
            schedules.postValue(scheduleResult.map {
                ScheduleUIModel(it, onClick = {})
            })
        }

    }

    fun showFilterBottomSheet() {
        ScheduleFragmentDirections.actionScheduleFragmentToScheduleFilterBottomSheetFragment()
            .navigate()
    }

}
