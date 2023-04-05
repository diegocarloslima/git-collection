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
import androidx.compose.ui.res.stringResource
import com.diegocarloslima.gitcollection.ui.strings.R as stringsR

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingsScreen() {
    LazyColumn {
        stickyHeader {
            SettingsCategory(
                title = stringResource(id = stringsR.string.settings_theme_category_title),
            )
        }
        item {
            SettingsItem(
                text = stringResource(id = stringsR.string.settings_theme_title),
                summary = stringResource(id = stringsR.string.settings_theme_default_summary),
            )
        }
        item {
            SettingsSwitch(
                text = stringResource(id = stringsR.string.settings_dynamic_colors_title),
                summary = stringResource(id = stringsR.string.settings_dynamic_colors_summary),
            )
        }
        stickyHeader {
            SettingsCategory(
                title = stringResource(id = stringsR.string.settings_app_category_title),
                divider = true,
            )
        }
        item {
            SettingsItem(
                text = stringResource(id = stringsR.string.settings_about_title),
            )
        }
        stickyHeader {
            SettingsCategory(title = "Test", divider = true)
        }
        item {
            SettingsItem(text = "Test")
        }
        item {
            SettingsItem(text = "Test")
        }
        item {
            SettingsItem(text = "Test")
        }
        item {
            SettingsItem(text = "Test")
        }
        item {
            SettingsItem(text = "Test")
        }
        item {
            SettingsItem(text = "Test")
        }
        item {
            SettingsItem(text = "Test")
        }
        item {
            SettingsItem(text = "Test")
        }
        item {
            SettingsItem(text = "Test")
        }
    }
}
