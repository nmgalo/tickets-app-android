package dev.nmgalo.domain.schedule

import dev.nmgalo.domain.schedule.model.TimeTableData
import kotlinx.coroutines.flow.Flow

interface ScheduleRepo {
    suspend fun get(): Flow<Iterable<TimeTableData>>
}