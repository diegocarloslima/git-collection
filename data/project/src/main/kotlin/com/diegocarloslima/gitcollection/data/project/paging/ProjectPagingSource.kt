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

package com.diegocarloslima.gitcollection.data.project.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.diegocarloslima.gitcollection.core.common.paging.Page
import com.diegocarloslima.gitcollection.data.project.ProjectDataSourceRemote
import com.diegocarloslima.gitcollection.data.project.model.Project

internal class ProjectPagingSource(
    private val remoteDataSource: ProjectDataSourceRemote,
) : PagingSource<String, Project>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Project> {
        return try {
            val projectPage = remoteDataSource.getPopularProjects(
                com.diegocarloslima.gitcollection.core.common.paging.Page(
                    PAGE_SIZE,
                    params.key,
                ),
            )
            LoadResult.Page(
                data = projectPage.projects,
                prevKey = params.key,
                nextKey = projectPage.nextKey,
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    // TODO: Figure this out
    override fun getRefreshKey(state: PagingState<String, Project>): String? {
        Log.i("GITTEST", "getRefreshKey")

        state.anchorPosition?.let { anchorPosition ->
            val index = state.pages.indexOf(state.closestPageToPosition(anchorPosition))
            Log.i("GITTEST", "getRefreshKey anchorPosition: $anchorPosition indexPage: $index")
        }

        return null
    }

    companion object {
        internal const val PAGE_SIZE = 25
    }
}
