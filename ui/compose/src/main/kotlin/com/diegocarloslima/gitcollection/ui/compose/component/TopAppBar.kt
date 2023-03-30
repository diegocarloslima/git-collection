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

package com.diegocarloslima.gitcollection.ui.compose.component

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    @StringRes titleRes: Int,
    actionImageVector: ImageVector,
    actionIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.smallTopAppBarColors(),
    onActionClick: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        modifier = modifier.testTag("TopAppBarComponent"),
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionImageVector,
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        colors = colors,
    )
}
