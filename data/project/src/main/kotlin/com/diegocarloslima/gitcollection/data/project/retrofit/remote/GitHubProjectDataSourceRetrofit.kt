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

package com.diegocarloslima.gitcollection.data.project.retrofit.remote

import com.diegocarloslima.gitcollection.core.network.github.GithubService
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryResults
import javax.inject.Inject

class GitHubProjectDataSourceRetrofit @Inject constructor(
    private val service: GithubService,
) {

    // TODO: Adjust return type
    suspend fun getPopularRepositories(page: Int): RepositoryResults =
        service.searchRepositories(QUERY_TRENDING, SORT_STARS, ORDER_DESC, PER_PAGE, page)
}

private const val QUERY_TRENDING = "android+language:java,android+language:kotlin"
private const val SORT_STARS = "stars"
private const val ORDER_DESC = "desc"
private const val PER_PAGE = 25
