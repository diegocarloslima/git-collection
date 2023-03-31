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
import androidx.compose.ui.tooling.preview.Preview
import com.diegocarloslima.gitcollection.R
import com.diegocarloslima.gitcollection.core.preferences.data.model.ThemePreference
import com.diegocarloslima.gitcollection.ui.compose.component.BackgroundComponent
import com.diegocarloslima.gitcollection.ui.compose.component.TopAppBarComponent
import com.diegocarloslima.gitcollection.ui.compose.icon.GitCollectionIcon
import com.diegocarloslima.gitcollection.ui.compose.theme.GitCollectionTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
internal fun MainScreen(
    mainUiState: MainUiState,
) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = when (mainUiState.theme) {
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
        dynamicColor = mainUiState.useDynamicColor,
    ) {
        MainScreenInternal()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScreenInternal() {
    BackgroundComponent {
        Scaffold(
            topBar = {
                TopAppBarComponent(
                    titleRes = R.string.app_name,
                    actionImageVector = GitCollectionIcon.Settings,
                    actionIconContentDescription = stringResource(id = R.string.settings),
                    onActionClick = {},
                )
            },
            bottomBar = {
                MainBottomBar()
            },
        ) { paddingValues ->
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                MainContent()
            }
        }
    }
}

@Composable
private fun MainContent() {
    Text("Hello World!")
}

@Composable
private fun MainBottomBar() {
    BottomAppBar {
        Text("BottomAppBar")
    }
}

@Preview(showBackground = true)
@Composable
private fun MainPreview() {
    GitCollectionTheme {
        MainScreenInternal()
    }
}
