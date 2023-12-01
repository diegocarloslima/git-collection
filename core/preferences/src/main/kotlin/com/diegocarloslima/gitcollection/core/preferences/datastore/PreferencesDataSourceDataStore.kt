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

package com.diegocarloslima.gitcollection.core.preferences.datastore

import androidx.datastore.core.DataStore
import com.diegocarloslima.gitcollection.core.preferences.PreferencesDataSource
import com.diegocarloslima.gitcollection.core.preferences.datastore.AppPreferencesProtoKt.Dsl
import com.diegocarloslima.gitcollection.core.preferences.model.AppPreferences
import com.diegocarloslima.gitcollection.core.preferences.model.ThemePreference
import com.diegocarloslima.gitcollection.core.preferences.model.mapToAppPreferences
import com.diegocarloslima.gitcollection.core.preferences.model.mapToThemePreferenceProto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferencesDataSourceDataStore @Inject constructor(
    private val dataStore: DataStore<AppPreferencesProto>,
) : PreferencesDataSource {
    override val preferences: Flow<AppPreferences> = dataStore.data.map { it.mapToAppPreferences() }

    override suspend fun setUseDynamicColor(useDynamicColor: Boolean) {
        updatePreferences {
            this.useDynamicColor = useDynamicColor
        }
    }

    override suspend fun setTheme(theme: ThemePreference) {
        updatePreferences {
            this.theme = theme.mapToThemePreferenceProto()
        }
    }

    override suspend fun updateProjectBookmarked(projectId: Long, bookmarked: Boolean) {
        updatePreferences {
            // TODO: Check if there's a better way of doing that
            val bookmarkedSet = this.bookmarkedProjectIds.toMutableSet()
            if (bookmarked) {
                bookmarkedSet.add(projectId)
            } else {
                bookmarkedSet.remove(projectId)
            }
            this.bookmarkedProjectIds.clear()
            this.bookmarkedProjectIds.addAll(bookmarkedSet)
        }
    }

    private suspend fun updatePreferences(block: Dsl.() -> Unit) {
        dataStore.updateData { it.copy(block) }
    }
}
