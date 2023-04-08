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

package com.diegocarloslima.gitcollection.app.main.ui

import com.diegocarloslima.gitcollection.app.main.ui.MainUiState.Loading
import com.diegocarloslima.gitcollection.app.main.ui.MainUiState.Success
import com.diegocarloslima.gitcollection.core.preferences.data.model.AppPreferences
import com.diegocarloslima.gitcollection.core.preferences.data.model.ThemePreference

internal val MainUiState.useDynamicColor: Boolean
    get() = when (this) {
        Loading -> AppPreferences.DEFAULT.useDynamicColor
        is Success -> this.appPreferences.useDynamicColor
    }

internal val MainUiState.theme: ThemePreference
    get() = when (this) {
        Loading -> AppPreferences.DEFAULT.theme
        is Success -> this.appPreferences.theme
    }
