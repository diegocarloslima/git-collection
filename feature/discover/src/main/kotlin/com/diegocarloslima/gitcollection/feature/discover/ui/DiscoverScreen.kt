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

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.diegocarloslima.gitcollection.data.project.model.Project
import kotlinx.coroutines.flow.Flow

@Composable
internal fun DiscoverScreen(
    projects: Flow<PagingData<Project>>,
) {
    val pagingItems: LazyPagingItems<Project> = projects.collectAsLazyPagingItems()
    LazyColumn {
        items(
            count = pagingItems.itemCount,
            key = { index ->
                val project = pagingItems[index]
                "${project?.id ?: ""}$index"
            },
        ) { index ->
            val project = pagingItems[index] ?: return@items
            Text(text = project.name)
            Divider()
        }
    }
}
