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

package com.diegocarloslima.gitcollection.core.preferences

import com.diegocarloslima.gitcollection.core.preferences.model.AppPreferences
import com.diegocarloslima.gitcollection.core.preferences.model.ThemePreference
import kotlinx.coroutines.flow.Flow

interface PreferencesDataSource {
    val preferences: Flow<AppPreferences>

    suspend fun setUseDynamicColor(useDynamicColor: Boolean)

    suspend fun setTheme(theme: ThemePreference)

    suspend fun updateProjectBookmarked(projectId: String, bookmarked: Boolean)
}
