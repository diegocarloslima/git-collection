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
import com.diegocarloslima.gitcollection.ui.compose.component.BackgroundComponent
import com.diegocarloslima.gitcollection.ui.compose.component.TopAppBarComponent
import com.diegocarloslima.gitcollection.ui.compose.icon.DefaultIcons
import com.diegocarloslima.gitcollection.ui.compose.theme.DefaultTheme
import com.diegocarloslima.gitcollection.ui.strings.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScaffold(appState: AppState) {
    val mainDestination = appState.currentMainDestination
    Scaffold(
        topBar = {
            if (mainDestination != null) {
                MainTopAppBar()
            }
        },
        bottomBar = {
            if (mainDestination != null) {
                MainBottomBar()
            }
        },
    ) { paddingValues ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            MainNavHost(navHostController = appState.navHostController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopAppBar() {
    TopAppBarComponent(
        titleRes = R.string.app_name,
        actionImageVector = DefaultIcons.Settings,
        actionIconContentDescription = stringResource(id = R.string.settings_name),
        onActionClick = {},
    )
}

@Composable
private fun MainBottomBar() {
    BottomAppBar {
        Text("BottomAppBar")
    }
}
