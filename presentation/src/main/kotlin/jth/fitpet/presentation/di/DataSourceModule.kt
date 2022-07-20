package jth.fitpet.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jth.fitpet.data.datasource.WeatherRemoteSource
import jth.fitpet.data.datasource.WeatherRemoteSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindWeatherRemoteSource(source: WeatherRemoteSourceImpl): WeatherRemoteSource
}