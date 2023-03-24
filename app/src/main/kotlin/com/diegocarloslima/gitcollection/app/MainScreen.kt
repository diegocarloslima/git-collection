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

package com.diegocarloslima.gitcollection.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.diegocarloslima.gitcollection.core.preferences.data.model.ThemePreference
import com.diegocarloslima.gitcollection.ui.compose.TestCoreUiGreeting
import com.diegocarloslima.gitcollection.ui.compose.theme.GitCollectionTheme

@Composable
internal fun MainScreen(
    mainUiState: MainUiState,
    modifier: Modifier = Modifier,
) {
    GitCollectionTheme(
        darkTheme = darkTheme(mainUiState),
        dynamicColor = dynamicColor(mainUiState),
    ) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            TestCoreUiGreeting("Android\na\na\na\na\na\na")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    GitCollectionTheme {
        Greeting("Android")
    }
}

@Composable
private fun dynamicColor(mainUiState: MainUiState): Boolean =
    when (mainUiState) {
        MainUiState.Loading -> true
        is MainUiState.Success -> mainUiState.appPreferences.useDynamicColor
    }

@Composable
private fun darkTheme(mainUiState: MainUiState): Boolean =
    when (mainUiState) {
        MainUiState.Loading -> isSystemInDarkTheme()
        is MainUiState.Success -> when (mainUiState.appPreferences.theme) {
            ThemePreference.SYSTEM_DEFAULT -> isSystemInDarkTheme()
            ThemePreference.DARK -> true
            ThemePreference.LIGHT -> false
        }
    }
