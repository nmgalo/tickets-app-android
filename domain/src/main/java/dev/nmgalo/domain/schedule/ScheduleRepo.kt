package dev.nmgalo.domain.schedule

import kotlinx.coroutines.flow.Flow

interface ScheduleRepo {
    suspend fun get()
}