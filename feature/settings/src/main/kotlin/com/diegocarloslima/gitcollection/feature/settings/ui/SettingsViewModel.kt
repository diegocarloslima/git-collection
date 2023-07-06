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

package com.diegocarloslima.gitcollection.feature.settings.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegocarloslima.gitcollection.core.preferences.data.PreferencesRepository
import com.diegocarloslima.gitcollection.core.preferences.data.model.ThemePreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SettingsViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository,
) : ViewModel() {
    val uiState: StateFlow<SettingsUiState> = preferencesRepository.preferences.map {
        SettingsUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = SettingsUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000),
    )

    fun updateTheme(theme: ThemePreference) {
        viewModelScope.launch {
            preferencesRepository.setTheme(theme)
        }
    }

    fun updateUseDynamicColor(useDynamicColor: Boolean) {
        viewModelScope.launch {
            preferencesRepository.setUseDynamicColor(useDynamicColor)
        }
    }
}
