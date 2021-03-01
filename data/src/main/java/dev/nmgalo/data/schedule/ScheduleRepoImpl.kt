package dev.nmgalo.data.schedule

import dev.nmgalo.data.ApiService
import dev.nmgalo.data.schedule.model.TimeTableDataDTO
import dev.nmgalo.domain.schedule.ScheduleRepo
import dev.nmgalo.domain.schedule.model.TimeTableData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ScheduleRepoImpl @Inject constructor(
    private val api: ApiService
) : ScheduleRepo {

    override suspend fun get(): Flow<List<TimeTableData>> = flow {
        emit(api.schedule().Data.map { it.toDomainModel() })
    }

    private fun TimeTableDataDTO.toDomainModel() = TimeTableData(
        FromStationNumber = FromStationNumber,
        FromStationNameEng = FromStationNameEng,
        FromStationNameGeo = FromStationNameGeo,
        ToStationNumber = ToStationNumber,
        ToStationNameEng = ToStationNameEng,
        ToStationNameGeo = ToStationNameGeo,
        RequestDate = RequestDate,
        GeorgianRailwayStationsId = GeorgianRailwayStationsId,
        LeavingDate = LeavingDate,
        EnteringDate = EnteringDate,
        TrainNumber = TrainNumber,
        TrainName = TrainName,
        IsTwoStorey = IsTwoStorey
    )

}