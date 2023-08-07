package com.scafisystems.classichearthstonecards.di

import android.content.Context
import com.scafisystems.classichearthstonecards.data.repository.CardRepository
import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import com.scafisystems.classichearthstonecards.domain.usecase.GetClassicCardsUseCase
import com.scafisystems.classichearthstonecards.domain.usecase.GetSelectCardUseCase
import com.scafisystems.classichearthstonecards.presenter.imageloader.GlideImageLoader
import com.scafisystems.classichearthstonecards.presenter.imageloader.ImageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun providesGetUserInfoUseCase(dataSource: CardDataSource): GetSelectCardUseCase {
        return GetSelectCardUseCase(dataSource)
    }

    @Provides
    @Singleton
    fun providesGlideImageLoader(@ApplicationContext appContext: Context): ImageLoader {
        return GlideImageLoader(appContext)
    }
}