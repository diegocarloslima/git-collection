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

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.diegocarloslima.gitcollection.data.project.ProjectDataSourceRemote
import com.diegocarloslima.gitcollection.data.project.model.Project

private const val START_PAGE = 1

internal class ProjectPagingSource(
    private val remoteDataSource: ProjectDataSourceRemote,
) : PagingSource<Int, Project>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Project> {
        val page = params.key ?: START_PAGE
        return try {
            val projects = remoteDataSource.getPopularProjects(params.loadSize, page)
            LoadResult.Page(
                data = projects,
                prevKey = if (page == START_PAGE) null else page.dec(),
                nextKey = if (projects.isEmpty()) null else page.inc(),
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    // The refresh key is used for subsequent refresh calls to PagingSource.load after the initial
    // load.
    override fun getRefreshKey(state: PagingState<Int, Project>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page that was
        // closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
