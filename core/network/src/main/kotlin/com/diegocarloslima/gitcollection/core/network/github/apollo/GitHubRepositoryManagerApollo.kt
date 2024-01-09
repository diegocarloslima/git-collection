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

package com.diegocarloslima.gitcollection.core.network.github.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.diegocarloslima.gitcollection.core.common.paging.Page
import com.diegocarloslima.gitcollection.core.network.di.GitHub
import com.diegocarloslima.gitcollection.core.network.github.GitHubRepositoryManagerNetwork
import com.diegocarloslima.gitcollection.core.network.github.GitHubSearchRepositoriesQuery
import com.diegocarloslima.gitcollection.core.network.github.apollo.model.mapToNetwork
import com.diegocarloslima.gitcollection.core.network.github.apollo.model.queryValue
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryResultsNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.SortOrder
import javax.inject.Inject

/**
 * Using Apollo GraphQL to manage GitHub repositories.
 */
internal class GitHubRepositoryManagerApollo @Inject constructor(
    @GitHub private val client: ApolloClient,
) : GitHubRepositoryManagerNetwork {
    override suspend fun searchRepositories(
        query: String,
        sortOrder: SortOrder,
        page: Page,
    ): RepositoryResultsNetwork {
        val fullQuery = "$query ${sortOrder.queryValue}"
        val searchRepositories = GitHubSearchRepositoriesQuery(
            Optional.presentIfNotNull(page.key),
            page.size,
            fullQuery,
        )
        val data = client.query(searchRepositories).execute().dataAssertNoErrors
        return data.mapToNetwork()
    }
}
