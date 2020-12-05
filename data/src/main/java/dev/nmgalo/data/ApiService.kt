package dev.nmgalo.data

import retrofit2.http.GET

interface ApiService {

    @GET("schedule")
    suspend fun schedule()

}