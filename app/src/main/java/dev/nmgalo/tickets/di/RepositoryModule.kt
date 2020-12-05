package dev.nmgalo.tickets.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.nmgalo.data.schedule.ScheduleRepoImpl
import dev.nmgalo.domain.schedule.ScheduleRepo

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideScheduleRepo(
        ScheduleRepo: ScheduleRepoImpl
    ): ScheduleRepo

}