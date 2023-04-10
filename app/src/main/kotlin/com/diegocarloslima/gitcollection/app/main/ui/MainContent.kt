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

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.diegocarloslima.gitcollection.app.home.ui.HOME_DESTINATION
import com.diegocarloslima.gitcollection.app.home.ui.homeGraph
import com.diegocarloslima.gitcollection.core.preferences.data.model.ThemePreference
import com.diegocarloslima.gitcollection.feature.settings.ui.settingsGraph
import com.diegocarloslima.gitcollection.ui.compose.theme.GitCollectionTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
internal fun MainContent(
    uiState: MainUiState,
) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = when (uiState.theme) {
        ThemePreference.SYSTEM_DEFAULT -> isSystemInDarkTheme()
        ThemePreference.DARK -> true
        ThemePreference.LIGHT -> false
    }

    // Update the dark content of the system bars to match the theme
    DisposableEffect(systemUiController, darkTheme) {
        systemUiController.systemBarsDarkContentEnabled = !darkTheme
        onDispose {}
    }

    GitCollectionTheme(
        darkTheme = darkTheme,
        dynamicColor = uiState.useDynamicColor,
    ) {
        val navController = rememberNavController()
        MainNavHost(navHostController = navController)
    }
}

@Composable
private fun MainNavHost(
    navHostController: NavHostController,
    startDestination: String = HOME_DESTINATION,
) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        homeGraph()
        settingsGraph()
    }
}
