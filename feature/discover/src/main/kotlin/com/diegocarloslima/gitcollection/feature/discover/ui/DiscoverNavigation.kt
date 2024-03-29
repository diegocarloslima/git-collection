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

package com.diegocarloslima.gitcollection.feature.discover.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val DISCOVER_DESTINATION = "discover_destination"

fun NavController.navigateToDiscover(navOptions: NavOptions? = null) {
    this.navigate(DISCOVER_DESTINATION, navOptions)
}

fun NavGraphBuilder.discoverGraph() {
    composable(route = DISCOVER_DESTINATION) {
        DiscoverRoute()
    }
}

@Composable
private fun DiscoverRoute(
    viewModel: DiscoverViewModel = hiltViewModel(),
) {
    DiscoverScreen(
        projects = viewModel.popularProjects,
        viewModel::updateProjectBookmarked,
    )
}
