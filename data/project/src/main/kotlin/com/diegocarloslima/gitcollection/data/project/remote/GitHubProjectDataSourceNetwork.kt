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

package com.diegocarloslima.gitcollection.data.project.remote

import com.diegocarloslima.gitcollection.core.network.github.GithubService
import com.diegocarloslima.gitcollection.data.project.ProjectDataSourceRemote
import com.diegocarloslima.gitcollection.data.project.model.Project
import com.diegocarloslima.gitcollection.data.project.model.mapToProject
import javax.inject.Inject

/**
 * Data source for retrieving GitHub repository projects using network.
 */
internal class GitHubProjectDataSourceNetwork @Inject constructor(
    private val service: GithubService,
) : ProjectDataSourceRemote {

    override suspend fun getPopularProjects(perPage: Int, page: Int): List<Project> {
        android.util.Log.i("GITTTEST", "perPage: $perPage page: $page")
        return service.searchRepositories(
            QUERY_TRENDING,
            SORT_STARS,
            ORDER_DESC,
            perPage,
            page,
        ).items.map { it.mapToProject() }
    }
}

private const val QUERY_TRENDING = "android+language:kotlin%20OR%20android+language:java"
private const val SORT_STARS = "stars"
private const val ORDER_DESC = "desc"
