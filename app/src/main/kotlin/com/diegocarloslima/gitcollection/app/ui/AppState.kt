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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.diegocarloslima.gitcollection.app.navigation.MainDestination
import com.diegocarloslima.gitcollection.feature.discover.ui.DISCOVER_DESTINATION

class AppState(
    val navHostController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navHostController
            .currentBackStackEntryAsState().value?.destination

    val currentHomeDestination: MainDestination?
        @Composable get() = when (currentDestination?.route) {
            DISCOVER_DESTINATION -> MainDestination.DISCOVER
            else -> null
        }
}

@Composable
fun rememberAppState(navHostController: NavHostController = rememberNavController()): AppState =
    remember(navHostController) {
        AppState(navHostController)
    }
