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

package com.diegocarloslima.gitcollection.app.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.diegocarloslima.gitcollection.app.navigation.MainNavHost
import com.diegocarloslima.gitcollection.core.preferences.data.model.ThemePreference
import com.diegocarloslima.gitcollection.feature.settings.ui.navigateToSettings
import com.diegocarloslima.gitcollection.ui.compose.component.BackgroundComponent
import com.diegocarloslima.gitcollection.ui.compose.component.TopAppBarAction
import com.diegocarloslima.gitcollection.ui.compose.component.TopAppBarComponent
import com.diegocarloslima.gitcollection.ui.compose.icon.DefaultIcons
import com.diegocarloslima.gitcollection.ui.compose.theme.DefaultTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.diegocarloslima.gitcollection.ui.strings.R as stringsR

@Composable
internal fun MainContent(
    uiState: MainUiState,
) {
    val appState = rememberAppState()
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

    DefaultTheme(
        darkTheme = darkTheme,
        dynamicColor = uiState.useDynamicColor,
    ) {
        BackgroundComponent {
            MainScaffold(appState)
        }
    }
}

@Composable
private fun MainScaffold(appState: AppState) {
    val mainDestination = appState.currentMainDestination
    Scaffold(
        topBar = {
            if (mainDestination != null) {
                MainTopAppBar(appState)
            }
        },
        bottomBar = {
            if (mainDestination != null) {
                MainBottomBar()
            }
        },
    ) { paddingValues ->
        var modifier = Modifier.fillMaxSize()
        // Only apply padding if it's a main destination
        if (mainDestination != null) {
            modifier = modifier.padding(paddingValues)
        }
        Row(modifier = modifier) {
            MainNavHost(navHostController = appState.navHostController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopAppBar(appState: AppState) {
    TopAppBarComponent(
        title = stringResource(id = stringsR.string.app_name),
        action = TopAppBarAction(
            image = DefaultIcons.Settings,
            contentDescription = stringResource(id = stringsR.string.settings_name),
            onClick = { appState.navHostController.navigateToSettings() },
        ),
    )
}

@Composable
private fun MainBottomBar() {
    BottomAppBar {
        Text("BottomAppBar")
    }
}
