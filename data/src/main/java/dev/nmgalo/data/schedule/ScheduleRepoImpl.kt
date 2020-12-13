package dev.nmgalo.data.schedule

import dev.nmgalo.data.ApiService
import dev.nmgalo.domain.schedule.ScheduleRepo
import dev.nmgalo.domain.schedule.model.TimeTableData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ScheduleRepoImpl @Inject constructor(
    private val api: ApiService
) : ScheduleRepo {

    override suspend fun get(): Flow<Iterable<TimeTableData>> = flow {
        api.schedule().let {
            it.Data.map { response ->
                TimeTableData(
                    response.FromStationNumber,
                    response.FromStationNameEng,
                    response.FromStationNameGeo,
                    response.ToStationNumber,
                    response.ToStationNameEng,
                    response.ToStationNameGeo,
                    response.RequestDate,
                    response.GeorgianRailwayStationsId,
                    response.LeavingDate,
                    response.EnteringDate,
                    response.TrainNumber,
                    response.TrainName,
                    response.IsTwoStorey
                )
            }
        }
    }


}