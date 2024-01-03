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
import com.diegocarloslima.gitcollection.core.network.github.fragment.RepositoryParts
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryLicenseNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryOwnerNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryResultsNetwork
import kotlinx.datetime.toInstant

internal fun GitHubSearchRepositoriesQuery.Data.mapToNetwork(): RepositoryResultsNetwork =
    RepositoryResultsNetwork(
        totalCount = this.search.repositoryCount.toLong(),
        items = this.search.nodes?.mapNotNull { it?.repositoryParts?.mapToNetwork() }
            ?: emptyList(),
        nextKey = this.search.pageInfo.endCursor,
    )

private fun RepositoryParts.mapToNetwork(): RepositoryNetwork =
    RepositoryNetwork(
        id = this.id,
        name = this.name,
        fullName = this.nameWithOwner,
        owner = this.owner.mapToNetwork(),
        htmlUrl = this.url.toString(),
        description = this.description,
        fork = this.isFork,
        createdAt = this.createdAt.toString().toInstant(),
        updatedAt = this.updatedAt.toString().toInstant(),
        pushedAt = this.pushedAt?.toString()?.toInstant(),
        homepage = this.homepageUrl?.toString(),
        stargazersCount = this.stargazerCount.toLong(),
        watchersCount = this.watchers.totalCount.toLong(),
        forksCount = this.forkCount.toLong(),
        openIssuesCount = this.issues.totalCount.toLong(),
        language = this.primaryLanguage?.name,
        license = this.licenseInfo?.mapToNetwork(),
        topics = this.repositoryTopics.nodes?.mapNotNull { it?.topic?.name } ?: emptyList(),
        defaultBranch = this.defaultBranchRef?.name,
    )

private fun RepositoryParts.Owner.mapToNetwork(): RepositoryOwnerNetwork =
    RepositoryOwnerNetwork(
        id = this.id,
        login = this.login,
        avatarUrl = this.avatarUrl.toString(),
        htmlUrl = this.url.toString(),
    )

private fun RepositoryParts.LicenseInfo.mapToNetwork(): RepositoryLicenseNetwork =
    RepositoryLicenseNetwork(
        name = this.name,
        url = this.url?.toString(),
    )
