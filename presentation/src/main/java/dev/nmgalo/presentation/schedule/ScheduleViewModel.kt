package dev.nmgalo.presentation.schedule

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
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
//            test Data, because it's corona time and tkt.ge api service is unavailable :(
            schedules.postValue(
                listOf(
                    ScheduleUIModel(
                        FromStationNumber = 1,
                        FromStationNameEng = "Tbilisi",
                        FromStationNameGeo = "თბილისი",
                        ToStationNumber = 1,
                        ToStationNameEng = "Batumi",
                        ToStationNameGeo = "ბათუმი",
                        RequestDate = "tableData.RequestDate",
                        GeorgianRailwayStationsId = 1,
                        LeavingDate = "tableData.LeavingDate",
                        EnteringDate = "tableData.EnteringDate",
                        TrainNumber = 812973,
                        TrainName = "tableData.TrainName",
                        IsTwoStorey = true,
                        onClick = {}
                    )
                )
            )
//            scheduleUseCase.get().collect { scheduleResult ->
//                schedules.postValue(
//                    scheduleResult.map { item -> item.toUIModel() }
//                )
//            }
        }
    }

    private fun TimeTableData.toUIModel(): ScheduleUIModel =
        ScheduleUIModel(
            tableData = this,
            onClick = {}
        )

}