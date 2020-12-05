package dev.nmgalo.data

import dev.nmgalo.data.schedule.model.TimeTableDTO
import retrofit2.http.GET

interface ApiService {

    @GET("stations/timetable")
    suspend fun schedule(): TimeTableDTO

}