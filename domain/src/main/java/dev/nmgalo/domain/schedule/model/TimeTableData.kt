package dev.nmgalo.domain.schedule.model

data class TimeTableData(
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
) {
    constructor(
        tableData: TimeTableData
    ) : this(
        FromStationNumber = tableData.FromStationNumber,
        FromStationNameEng = tableData.FromStationNameEng,
        FromStationNameGeo = tableData.FromStationNameGeo,
        ToStationNumber = tableData.ToStationNumber,
        ToStationNameEng = tableData.ToStationNameEng,
        ToStationNameGeo = tableData.ToStationNameGeo,
        RequestDate = tableData.RequestDate,
        GeorgianRailwayStationsId = tableData.GeorgianRailwayStationsId,
        LeavingDate = tableData.LeavingDate,
        EnteringDate = tableData.EnteringDate,
        TrainNumber = tableData.TrainNumber,
        TrainName = tableData.TrainName,
        IsTwoStorey = tableData.IsTwoStorey
    )
}