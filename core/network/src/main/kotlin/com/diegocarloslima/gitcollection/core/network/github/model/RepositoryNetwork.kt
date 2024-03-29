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

package com.diegocarloslima.gitcollection.core.network.github.model

import kotlinx.datetime.Instant

/**
 * This class holds information about a repository in GitHub.
 */
data class RepositoryNetwork(
    val id: String,
    val name: String,
    val fullName: String,
    val owner: RepositoryOwnerNetwork,
    val htmlUrl: String,
    val description: String?,
    val archived: Boolean,
    val fork: Boolean,
    val mirror: Boolean,
    val createdAt: Instant,
    val updatedAt: Instant,
    val pushedAt: Instant?,
    val homepage: String?,
    val size: Long?,
    val stargazersCount: Long,
    val watchersCount: Long,
    val forksCount: Long,
    val openIssuesCount: Long,
    val language: String?,
    val license: RepositoryLicenseNetwork?,
    val topics: List<String>,
    val defaultBranch: String?,
)
