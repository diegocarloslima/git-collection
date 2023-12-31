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

package com.diegocarloslima.gitcollection.core.network.github.apollo.model

import com.diegocarloslima.gitcollection.core.network.github.GitHubSearchRepositoriesQuery
import com.diegocarloslima.gitcollection.core.network.github.model.Pagination
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryResultsNetwork

internal fun GitHubSearchRepositoriesQuery.Data.mapToNetwork(
    pagination: Pagination,
): RepositoryResultsNetwork =
    RepositoryResultsNetwork(
        totalCount = this.search.repositoryCount.toLong(),
        items = this.search.nodes?.mapNotNull { it?.mapToNetwork() } ?: emptyList(),
        nextKey = this.search.pageInfo.endCursor,
    )

private fun GitHubSearchRepositoriesQuery.Node.mapToNetwork(): RepositoryNetwork = TODO()
//    RepositoryNetwork(
//        id = this.repositoryParts!!.id,
//    )
