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

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.diegocarloslima.gitcollection.core.preferences.data.model.ThemePreference
import com.diegocarloslima.gitcollection.ui.compose.theme.supportsDynamicColor
import com.diegocarloslima.gitcollection.ui.strings.R as stringsR

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun SettingsScreen(
    uiState: SettingsUiState,
    supportsDynamicColor: Boolean = supportsDynamicColor(),
    onBackClick: () -> Unit,
    onSelectTheme: (theme: ThemePreference) -> Unit,
    onSelectUseDynamicColor: (useDynamicColor: Boolean) -> Unit,
) {
    LazyColumn {
        stickyHeader {
            SettingsCategory(
                title = stringResource(id = stringsR.string.settings_theme_category_title),
            )
        }
        item {
            SettingsListSingle(
                title = stringResource(id = stringsR.string.settings_theme_title),
                entries = stringArrayResource(id = stringsR.array.settings_theme_entries).toList(),
                selectedEntryIndex = 0,
                summary = stringResource(id = stringsR.string.settings_theme_default_summary),
            ) { index, entry -> }
        }
        if (supportsDynamicColor) {
            item {
                SettingsSwitch(
                    title = stringResource(id = stringsR.string.settings_dynamic_colors_title),
                    checked = uiState.useDynamicColor,
                    summary = stringResource(id = stringsR.string.settings_dynamic_colors_summary),
                ) { onSelectUseDynamicColor(it) }
            }
        }
        stickyHeader {
            SettingsCategory(
                title = stringResource(id = stringsR.string.settings_app_category_title),
                divider = true,
            )
        }
        item {
            SettingsItem(
                title = stringResource(id = stringsR.string.settings_about_title),
            )
        }
    }
}
