package dev.nmgalo.data.schedule.model

import kotlinx.serialization.Serializable

@Serializable
data class TimeTableDTO(
    val Data: List<TimeTableDataDTO>,
    val Success: Boolean
)