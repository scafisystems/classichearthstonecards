package com.scafisystems.classichearthstonecards.di

import com.scafisystems.classichearthstonecards.data.repository.CardRepository
import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import com.scafisystems.classichearthstonecards.domain.usecase.GetClassicCardsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMomentRepository(): CardDataSource {
        return CardRepository()
    }

    @Provides
    @Singleton
    fun providesGetClassicCardsUseCase(dataSource: CardDataSource): GetClassicCardsUseCase {
        return GetClassicCardsUseCase(dataSource)
    }
}