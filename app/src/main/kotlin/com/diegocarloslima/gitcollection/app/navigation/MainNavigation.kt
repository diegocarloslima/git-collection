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

package com.diegocarloslima.gitcollection.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.diegocarloslima.gitcollection.feature.discover.ui.DISCOVER_DESTINATION
import com.diegocarloslima.gitcollection.feature.discover.ui.discoverGraph
import com.diegocarloslima.gitcollection.feature.discover.ui.navigateToDiscover
import com.diegocarloslima.gitcollection.feature.saved.ui.navigateToSaved
import com.diegocarloslima.gitcollection.feature.saved.ui.savedGraph
import com.diegocarloslima.gitcollection.feature.search.ui.navigateToSearch
import com.diegocarloslima.gitcollection.feature.search.ui.searchGraph
import com.diegocarloslima.gitcollection.feature.settings.ui.settingsGraph

@Composable
internal fun MainNavHost(
    navHostController: NavHostController,
    startDestination: String = DISCOVER_DESTINATION,
) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        discoverGraph()
        savedGraph()
        searchGraph()
        settingsGraph(navHostController)
    }
}

internal fun NavHostController.navigateToMainDestination(mainDestination: MainDestination) {
    val navOptions = navOptions {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(this@navigateToMainDestination.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when re-selecting the same item
        launchSingleTop = true
        // Restore state when re-selecting a previously selected item
        restoreState = true
    }

    when (mainDestination) {
        MainDestination.DISCOVER -> this.navigateToDiscover(navOptions)
        MainDestination.SAVED -> this.navigateToSaved(navOptions)
        MainDestination.SEARCH -> this.navigateToSearch(navOptions)
    }
}
