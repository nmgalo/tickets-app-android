package dev.nmgalo.domain

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import dev.nmgalo.domain.schedule.ScheduleRepo
import dev.nmgalo.domain.schedule.model.TimeTableData
import dev.nmgalo.domain.schedule.usecase.GetScheduleUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetScheduleUseCaseTest {

    private val timeTableData = TimeTableData(
        FromStationNumber = 1,
        FromStationNameGeo = "სატესტო",
        FromStationNameEng = "TEST",
        ToStationNameGeo = "ტესტო",
        ToStationNameEng = "testi ovsom",
        ToStationNumber = 1212,
        RequestDate = "",
        GeorgianRailwayStationsId = 1,
        LeavingDate = "",
        EnteringDate = "",
        TrainNumber = 12,
        TrainName = "122222",
        IsTwoStorey = false,
    )

    private val scheduleRepo = mock<ScheduleRepo> {
        runBlocking {
            on(mock.get()) doReturn flowOf(listOf(timeTableData))
        }
    }

    private val useCase = GetScheduleUseCase(scheduleRepo)


    @Test
    fun should_returnOne_When_FromStationNumberIsOne() = runBlocking {
        useCase.get().collect { result ->
            result.map {
                Assert.assertEquals("stationNumberIsOne", 1, it.FromStationNumber)
            }
        }
    }

}
