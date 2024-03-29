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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

private const val SETTINGS_DESTINATION = "settings_main_destination"

fun NavController.navigateToSettings() {
    this.navigate(SETTINGS_DESTINATION)
}

fun NavGraphBuilder.settingsGraph(navHostController: NavHostController) {
    composable(route = SETTINGS_DESTINATION) {
        SettingsRoute(
            onBackClick = navHostController::popBackStack,
            onAboutClick = { navHostController.navigateToAbout() },
        )
    }
    aboutGraph(navHostController)
}

@Composable
private fun SettingsRoute(
    onBackClick: () -> Unit,
    onAboutClick: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    SettingsScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onThemeSelect = viewModel::updateTheme,
        onUseDynamicColorSelect = viewModel::updateUseDynamicColor,
        onAboutClick = onAboutClick,
    )
}
