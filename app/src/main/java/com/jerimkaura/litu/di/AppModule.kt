package com.jerimkaura.litu.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jerimkaura.litu.data.remote.LitudianAPI
import com.jerimkaura.litu.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
             .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideOkhttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideLitudianAPI(retrofit: Retrofit): LitudianAPI {
        return retrofit.create(LitudianAPI::class.java)
    }
}