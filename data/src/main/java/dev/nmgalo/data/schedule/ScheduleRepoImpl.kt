package dev.nmgalo.data.schedule

import dev.nmgalo.data.ApiService
import dev.nmgalo.domain.schedule.ScheduleRepo
import javax.inject.Inject

class ScheduleRepoImpl @Inject constructor(
    private val api: ApiService
) : ScheduleRepo {

    override suspend fun get() {}

}