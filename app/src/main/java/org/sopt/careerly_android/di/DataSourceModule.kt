package org.sopt.careerly_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.careerly_android.data.datasource.PostDataSource
import org.sopt.careerly_android.data.datasource.remote.PostDataSourceImpl
import org.sopt.careerly_android.data.repository.PostRepositoryImpl
import org.sopt.careerly_android.domain.PostRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun providePostDataSource(dataSource: PostDataSourceImpl): PostDataSource = dataSource
}
