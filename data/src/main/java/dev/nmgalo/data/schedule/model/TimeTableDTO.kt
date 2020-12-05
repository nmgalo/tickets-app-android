package dev.nmgalo.data.schedule.model

import kotlinx.serialization.Serializable

@Serializable
data class TimeTableDTO(
    val Data: List<TimeTableDataDTO>,
    val Errors: List<Any>,
    val Success: Boolean
)