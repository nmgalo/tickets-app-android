package dev.nmgalo.tickets.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.nmgalo.data.ApiService
import dev.nmgalo.data.getRetrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideApiService(): ApiService {
        return getRetrofit().create()
    }

}
