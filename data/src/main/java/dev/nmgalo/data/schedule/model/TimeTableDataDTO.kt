package dev.nmgalo.data.schedule.model

import kotlinx.serialization.Serializable

@Serializable
data class TimeTableDataDTO(
    val FromStationNumber: Int,
    val FromStationNameEng: String,
    val FromStationNameGeo: String,
    val ToStationNumber: Int,
    val ToStationNameEng: String,
    val ToStationNameGeo: String,
    val RequestDate: String,
    val GeorgianRailwayStationsId: Int,
    val LeavingDate: String,
    val EnteringDate: String,
    val TrainNumber: Int,
    val TrainName: String,
    val IsTwoStorey: Boolean
)