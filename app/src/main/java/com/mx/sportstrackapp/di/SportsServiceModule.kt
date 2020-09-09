package com.mx.sportstrackapp.di

import com.mx.sportstrackapp.search.api.SportsDbService
import com.mx.sportstrackapp.search.api.SportsDbService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object SportsServiceModule {

    @Singleton
    @Provides
    fun provideSportsDbService(
        @SportsServiceClient okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = provideService(okHttpClient, converterFactory, SportsDbService::class.java)

    private fun <T> provideService(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory,
        clazz: Class<T>
    ): T {
        return buildRetrofitInstance(okHttpClient, converterFactory)
            .create(clazz)
    }

    private fun buildRetrofitInstance(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()

    }
}