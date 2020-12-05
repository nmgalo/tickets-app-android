package dev.nmgalo.domain.schedule.usecase

import dev.nmgalo.domain.schedule.ScheduleRepo
import javax.inject.Inject

class GetScheduleUseCase @Inject constructor(
    private val repo: ScheduleRepo
) {
    suspend fun get() = repo.get()
}