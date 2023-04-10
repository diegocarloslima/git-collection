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

package com.diegocarloslima.gitcollection.app.home.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.diegocarloslima.gitcollection.ui.compose.component.BackgroundComponent
import com.diegocarloslima.gitcollection.ui.compose.component.TopAppBarComponent
import com.diegocarloslima.gitcollection.ui.compose.icon.GitCollectionIcon
import com.diegocarloslima.gitcollection.ui.strings.R.string

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen() {
    BackgroundComponent {
        Scaffold(
            topBar = { HomeTopAppBar() },
            bottomBar = { HomeBottomBar() },
        ) { paddingValues ->
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                Text("Hello Home!")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopAppBar() {
    TopAppBarComponent(
        titleRes = string.app_name,
        actionImageVector = GitCollectionIcon.Settings,
        actionIconContentDescription = stringResource(id = string.settings_name),
        onActionClick = {},
    )
}

@Composable
private fun HomeBottomBar() {
    BottomAppBar {
        Text("BottomAppBar")
    }
}
