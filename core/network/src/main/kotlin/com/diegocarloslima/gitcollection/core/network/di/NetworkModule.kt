/*
 * This file is part of Git Collection.
 * Copyright (C) 2023-present Diego Carlos Lima <https://diegocarloslima.com/>
 *
 * Git Collection is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Git Collection is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.diegocarloslima.gitcollection.core.network.di

import com.diegocarloslima.gitcollection.core.network.BuildConfig
import com.diegocarloslima.gitcollection.core.network.github.GithubService
import com.diegocarloslima.gitcollection.core.network.github.retrofit.GithubServiceRetrofit
import com.diegocarloslima.gitcollection.core.network.util.HttpHeader
import com.diegocarloslima.gitcollection.core.network.util.MediaType
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideGithubService(json: Json): GithubService =
        Retrofit.Builder()
            .baseUrl(GithubService.BASE_URL)
            .addConverterFactory(json.toConverterFactory())
            .build()
            .create(GithubServiceRetrofit::class.java)

    @Provides
    @Singleton
    fun provideJson(): Json =
        Json {
            ignoreUnknownKeys = true
        }

    @Provides
    @Singleton
    fun provideCallFactory(): Call.Factory =
        OkHttpClient.Builder()
            .addInterceptor(interceptor())
            .build()

    private fun interceptor(): Interceptor =
        HttpLoggingInterceptor().apply {
            redactHeader(HttpHeader.AUTHORIZATION)
            if (BuildConfig.DEBUG) {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        }

    private fun Json.toConverterFactory(): Converter.Factory =
        this.asConverterFactory(MediaType.APPLICATION_JSON.toMediaType())
}