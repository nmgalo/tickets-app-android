package dev.nmgalo.domain.schedule.usecase

import dev.nmgalo.domain.schedule.ScheduleRepo
import dev.nmgalo.domain.schedule.model.TimeTableData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetScheduleUseCase @Inject constructor(
    private val repo: ScheduleRepo
) {
    suspend fun get(): Flow<Iterable<TimeTableData>> = flow {
        repo.get().collect { emit(it) }
    }.flowOn(Dispatchers.IO)
}