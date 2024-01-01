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

package com.diegocarloslima.gitcollection.core.network.github.retrofit

import com.diegocarloslima.gitcollection.core.network.github.GitHubRepositoryManagerNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryResultsNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.SortOrder
import com.diegocarloslima.gitcollection.core.network.github.retrofit.model.mapToNetwork
import com.diegocarloslima.gitcollection.core.network.github.retrofit.model.orderValue
import com.diegocarloslima.gitcollection.core.network.github.retrofit.model.pageNumber
import com.diegocarloslima.gitcollection.core.network.github.retrofit.model.sortValue
import com.diegocarloslima.gitcollection.core.network.model.Pagination
import javax.inject.Inject

/**
 * Using Retrofit to manage GitHub repositories.
 */
internal class GitHubRepositoryManagerRetrofit @Inject constructor(
    private val service: GitHubServiceRetrofit,
) : GitHubRepositoryManagerNetwork {
    override suspend fun searchRepositories(
        query: String,
        sortOrder: SortOrder,
        pagination: Pagination,
    ): RepositoryResultsNetwork {
        val result = service.searchRepositories(
            query,
            sortOrder.sortValue,
            sortOrder.orderValue,
            pagination.size,
            pagination.pageNumber,
        )

        val nextPageNumber = if (result.totalCount > pagination.pageNumber * pagination.size) {
            pagination.pageNumber.inc()
        } else {
            null
        }

        return result.mapToNetwork(nextPageNumber.toString())
    }
}
