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

package com.diegocarloslima.gitcollection.core.preferences.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.diegocarloslima.gitcollection.core.preferences.PreferencesDataSource
import com.diegocarloslima.gitcollection.core.preferences.PreferencesRepository
import com.diegocarloslima.gitcollection.core.preferences.PreferencesRepositoryDefault
import com.diegocarloslima.gitcollection.core.preferences.datastore.AppPreferencesProto
import com.diegocarloslima.gitcollection.core.preferences.datastore.AppPreferencesSerializer
import com.diegocarloslima.gitcollection.core.preferences.datastore.PreferencesDataSourceDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PreferencesModule {
    @Binds
    fun bindsPreferencesRepository(
        preferencesRepositoryDefault: PreferencesRepositoryDefault,
    ): PreferencesRepository

    @Binds
    fun bindsPreferencesDataSource(
        preferencesDataSourceDataStore: PreferencesDataSourceDataStore,
    ): PreferencesDataSource

    companion object {
        @Provides
        @Singleton
        fun providesAppPreferencesDataStore(
            @ApplicationContext context: Context,
            appPreferencesSerializer: AppPreferencesSerializer,
        ): DataStore<AppPreferencesProto> =
            DataStoreFactory.create(
                serializer = appPreferencesSerializer,
            ) {
                context.dataStoreFile("app_preferences.pb")
            }
    }
}
