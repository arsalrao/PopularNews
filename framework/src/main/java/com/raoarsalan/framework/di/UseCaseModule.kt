package com.raoarsalan.framework.di

import com.raoarsalan.core.data.repository.NewsRepository
import com.raoarsalan.core.domain.interactor.NewsInteractor
import com.raoarsalan.core.domain.interactor.NewsInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideNewsInteractor(repo: NewsRepository): NewsInteractor = NewsInteractorImpl(repo)
}