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

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpCallFactory
import com.diegocarloslima.gitcollection.core.network.BuildConfig
import com.diegocarloslima.gitcollection.core.network.github.GitHubConfig
import com.diegocarloslima.gitcollection.core.network.github.GitHubRepositoryManagerNetwork
import com.diegocarloslima.gitcollection.core.network.github.apollo.GitHubRepositoryManagerApollo
import com.diegocarloslima.gitcollection.core.network.github.retrofit.GitHubServiceRetrofit
import com.diegocarloslima.gitcollection.core.network.okhttp.AuthorizationInterceptor
import com.diegocarloslima.gitcollection.core.network.util.HttpHeader
import com.diegocarloslima.gitcollection.core.network.util.HttpMediaType
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
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

/**
 * Common Hilt dependency configuration for the network module.
 */
@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkModule {
    @Binds
    abstract fun bindGitHubRepositoryManagerNetwork(
        manager: GitHubRepositoryManagerApollo,
    ): GitHubRepositoryManagerNetwork

    companion object {
        @Provides
        @Singleton
        @GitHub
        fun provideGitHubApolloClient(
            gitHubConfig: GitHubConfig,
            callFactory: Call.Factory,
        ): ApolloClient =
            ApolloClient.Builder()
                .serverUrl(gitHubConfig.graphQlUrl)
                .okHttpCallFactory(callFactory)
                .build()

        @Provides
        @Singleton
        fun provideGitHubServiceRetrofit(
            gitHubConfig: GitHubConfig,
            callFactory: Call.Factory,
            json: Json,
        ): GitHubServiceRetrofit =
            Retrofit.Builder()
                .baseUrl(gitHubConfig.restUrl)
                .callFactory(callFactory)
                .addConverterFactory(json.toConverterFactory())
                .build()
                .create(GitHubServiceRetrofit::class.java)

        @Provides
        @Singleton
        fun provideJson(): Json =
            Json {
                ignoreUnknownKeys = true
            }

        @Provides
        @Singleton
        fun provideCallFactory(): Call.Factory =
            OkHttpClient.Builder().run {
                addInterceptor(loggingInterceptor())
                @Suppress("KotlinConstantConditions")
                if (BuildConfig.GITHUB_PAT != INVALID_TOKEN) {
                    addInterceptor(authInterceptor())
                }
                build()
            }
    }
}

private const val INVALID_TOKEN: String = "INVALID_TOKEN"

private fun authInterceptor(): Interceptor =
    AuthorizationInterceptor(BuildConfig.GITHUB_PAT)

private fun loggingInterceptor(): Interceptor =
    HttpLoggingInterceptor().apply {
        redactHeader(HttpHeader.AUTHORIZATION)
        if (BuildConfig.DEBUG) {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

private fun Json.toConverterFactory(): Converter.Factory =
    this.asConverterFactory(HttpMediaType.APPLICATION_JSON.toMediaType())
