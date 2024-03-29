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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import com.diegocarloslima.gitcollection.core.preferences.model.ThemePreference
import com.diegocarloslima.gitcollection.ui.common.theme.supportsDynamicColor
import com.diegocarloslima.gitcollection.ui.strings.R as stringsR

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun SettingsScreen(
    uiState: SettingsUiState,
    supportsDynamicColor: Boolean = supportsDynamicColor(),
    onBackClick: () -> Unit,
    onThemeSelect: (theme: ThemePreference) -> Unit,
    onUseDynamicColorSelect: (useDynamicColor: Boolean) -> Unit,
    onAboutClick: () -> Unit,
) {
    SettingsScaffold(
        title = stringResource(id = stringsR.string.settings_title),
        onBackClick = onBackClick,
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            stickyHeader {
                SettingsCategory(
                    title = stringResource(id = stringsR.string.settings_theme_category_title),
                )
            }
            item {
                SettingsListSingle(
                    title = stringResource(id = stringsR.string.settings_theme_title),
                    entries = ThemePreference.values()
                        .map { stringResource(id = it.stringRes) },
                    selectedEntryIndex = uiState.theme.ordinal,
                    summary = stringResource(id = stringsR.string.settings_theme_default_summary),
                ) { index, _ ->
                    onThemeSelect(ThemePreference.values()[index])
                }
            }
            if (supportsDynamicColor) {
                item {
                    SettingsSwitch(
                        title = stringResource(id = stringsR.string.settings_dynamic_colors_title),
                        checked = uiState.useDynamicColor,
                        summary = stringResource(id = stringsR.string.settings_dynamic_colors_summary),
                    ) { onUseDynamicColorSelect(it) }
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
                    modifier = Modifier.clickable(
                        role = Role.Button,
                        onClick = onAboutClick,
                    ),
                )
            }
        }
    }
}

private val ThemePreference.stringRes: Int
    get() = when (this) {
        ThemePreference.SYSTEM_DEFAULT -> stringsR.string.settings_theme_system_default
        ThemePreference.LIGHT -> stringsR.string.settings_theme_light
        ThemePreference.DARK -> stringsR.string.settings_theme_dark
    }
