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
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

private const val ABOUT_DESTINATION = "settings_about_destination"

internal fun NavController.navigateToAbout() {
    this.navigate(ABOUT_DESTINATION)
}

internal fun NavGraphBuilder.aboutGraph(navHostController: NavHostController) {
    composable(route = ABOUT_DESTINATION) {
        AboutRoute(onBackClick = navHostController::popBackStack)
    }
}

@Composable
private fun AboutRoute(onBackClick: () -> Unit) {
    AboutScreen(onBackClick)
}
