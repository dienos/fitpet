package jth.fitpet.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import jth.fitpet.domain.repository.WeatherRepository
import jth.fitpet.domain.usecase.GetWeathersUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetSampleUseCase(repository: WeatherRepository): GetWeathersUseCase {
        return GetWeathersUseCase(repository)
    }
}