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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.diegocarloslima.gitcollection.data.project.model.Project
import com.diegocarloslima.gitcollection.ui.compose.icon.DefaultIcons

@Composable
internal fun DiscoverProjectCard(
    project: Project,
) {
    Card(
        shape = RoundedCornerShape(16.dp),
    ) {
        Column {
            Row {
                Icon(imageVector = DefaultIcons.Home, contentDescription = "TODO")
                Column {
                    Text(text = project.owner)
                    Text(text = project.name)
                }
                Icon(imageVector = DefaultIcons.FavoriteOutlined, contentDescription = "TODO")
            }
        }
    }
}
