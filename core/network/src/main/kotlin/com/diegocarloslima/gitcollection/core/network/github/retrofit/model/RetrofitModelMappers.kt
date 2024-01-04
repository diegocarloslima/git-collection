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

package com.diegocarloslima.gitcollection.core.network.github.retrofit.model

import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryLicenseNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryOwnerNetwork
import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryResultsNetwork

internal fun RepositoryResultsRetrofit.mapToNetwork(nextKey: String?): RepositoryResultsNetwork =
    RepositoryResultsNetwork(
        totalCount = this.totalCount,
        items = this.items.map { it.mapToNetwork() },
        nextKey = nextKey,
    )

private fun RepositoryRetrofit.mapToNetwork(): RepositoryNetwork =
    RepositoryNetwork(
        id = this.id.toString(),
        name = this.name,
        fullName = this.fullName,
        owner = this.owner.mapToNetwork(),
        htmlUrl = this.htmlUrl,
        description = this.description,
        archived = this.archived,
        fork = this.fork,
        mirror = this.mirrorUrl != null,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        pushedAt = this.pushedAt,
        homepage = this.homepage,
        size = this.size,
        stargazersCount = this.stargazersCount,
        watchersCount = this.watchersCount,
        forksCount = this.forksCount,
        openIssuesCount = this.openIssuesCount,
        language = this.language,
        license = this.license?.mapToNetwork(),
        topics = this.topics,
        defaultBranch = this.defaultBranch,
    )

private fun RepositoryOwnerRetrofit.mapToNetwork(): RepositoryOwnerNetwork =
    RepositoryOwnerNetwork(
        id = this.id.toString(),
        login = this.login,
        avatarUrl = this.avatarUrl,
        htmlUrl = this.htmlUrl,
    )

private fun RepositoryLicenseRetrofit.mapToNetwork(): RepositoryLicenseNetwork =
    RepositoryLicenseNetwork(
        id = this.id.toString(),
        name = this.name,
        url = this.url,
    )
