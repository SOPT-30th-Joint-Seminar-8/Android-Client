package org.sopt.careerly_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.careerly_android.data.remote.service.GetService
import org.sopt.careerly_android.data.remote.service.PostService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providePostService(retrofit: Retrofit): PostService =
        retrofit.create(PostService::class.java)

    @Provides
    @Singleton
    fun provideGetService(retrofit: Retrofit): GetService =
        retrofit.create(GetService::class.java)
}
