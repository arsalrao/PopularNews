package com.raoarsalan.framework.di

import com.raoarsalan.core.data.repository.NewsRepository
import com.raoarsalan.framework.database.dao.NewsDao
import com.raoarsalan.framework.network.apis.NewsApi
import com.raoarsalan.framework.repositoryimpl.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideNewsRepo(api: NewsApi, dao: NewsDao): NewsRepository = NewsRepositoryImpl(api, dao)
}