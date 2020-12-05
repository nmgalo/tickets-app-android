package dev.nmgalo.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

fun getOkHttp(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .url(
                    chain.request().url.newBuilder()
                        .addQueryParameter("api_key", "7d8d34d1-e9af-4897-9f0f-5c36c179be77")
                        .build()
                )
            chain.proceed(request.build())
        }.build()
}

fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .client(getOkHttp())
        .baseUrl("https://api.tkt.ge/v2/gr/")
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        ).build()
}