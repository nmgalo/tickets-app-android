package dev.nmgalo.tickets.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.nmgalo.data.ApiService
import dev.nmgalo.data.getRetrofit
import retrofit2.create

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideApiService(): ApiService {
        return getRetrofit().create()
    }

}
