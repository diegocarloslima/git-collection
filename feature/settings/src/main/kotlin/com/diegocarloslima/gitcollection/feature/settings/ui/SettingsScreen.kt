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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.diegocarloslima.gitcollection.core.preferences.data.model.ThemePreference
import com.diegocarloslima.gitcollection.ui.compose.theme.supportsDynamicColor
import com.diegocarloslima.gitcollection.ui.strings.R as stringsR

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun SettingsScreen(
    uiState: SettingsUiState,
    supportsDynamicColor: Boolean = supportsDynamicColor(),
    onBackClick: () -> Unit,
    onSelectTheme: (theme: ThemePreference) -> Unit,
    onSelectUseDynamicColor: (useDynamicColor: Boolean) -> Unit,
) {
    Scaffold(
        topBar = {
//            Text(text = "TopBar")
//            TopAppBarComponent(
//                titleRes = stringsR.string.settings_name,
//                actionImageVector = DefaultIcons.ArrowBack,
//                actionIconContentDescription = stringResource(id = stringsR.string.action_back),
//                onActionClick = onBackClick,
// //                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Yellow)
//            )
        },
    ) { paddingValues ->
        android.util.Log.i("GITTEST", "paddingSettings: $paddingValues")
        Surface(color = Color.Magenta) {
            Text(
                text = "Hello World",
                modifier = Modifier
                    .fillMaxSize().padding(paddingValues),
            )
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues)
//            ) {
//                stickyHeader {
//                    SettingsCategory(
//                        title = stringResource(id = stringsR.string.settings_theme_category_title),
//                    )
//                }
//                item {
//                    SettingsListSingle(
//                        title = stringResource(id = stringsR.string.settings_theme_title),
//                        entries = ThemePreference.values()
//                            .map { stringResource(id = it.stringRes) },
//                        selectedEntryIndex = uiState.theme.ordinal,
//                        summary = stringResource(id = stringsR.string.settings_theme_default_summary),
//                    ) { index, _ ->
//                        onSelectTheme(ThemePreference.values()[index])
//                    }
//                }
//                if (supportsDynamicColor) {
//                    item {
//                        SettingsSwitch(
//                            title = stringResource(id = stringsR.string.settings_dynamic_colors_title),
//                            checked = uiState.useDynamicColor,
//                            summary = stringResource(id = stringsR.string.settings_dynamic_colors_summary),
//                        ) { onSelectUseDynamicColor(it) }
//                    }
//                }
//                stickyHeader {
//                    SettingsCategory(
//                        title = stringResource(id = stringsR.string.settings_app_category_title),
//                        divider = true,
//                    )
//                }
//                item {
//                    SettingsItem(
//                        title = stringResource(id = stringsR.string.settings_about_title),
//                    )
//                }
//            }
        }
    }
}

private val ThemePreference.stringRes: Int
    get() = when (this) {
        ThemePreference.SYSTEM_DEFAULT -> stringsR.string.settings_theme_system_default
        ThemePreference.LIGHT -> stringsR.string.settings_theme_light
        ThemePreference.DARK -> stringsR.string.settings_theme_dark
    }
