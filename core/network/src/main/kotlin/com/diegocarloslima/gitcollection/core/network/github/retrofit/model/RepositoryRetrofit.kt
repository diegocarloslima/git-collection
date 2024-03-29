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

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This class holds information about a repository in GitHub loaded using Retrofit.
 */
@Serializable
internal data class RepositoryRetrofit(
    @SerialName("node_id") val id: String,
    val name: String,
    @SerialName("full_name") val fullName: String,
    val owner: RepositoryOwnerRetrofit,
    @SerialName("html_url") val htmlUrl: String,
    val description: String?,
    val archived: Boolean,
    val fork: Boolean,
    @SerialName("mirror_url") val mirrorUrl: String?,
    @SerialName("created_at") val createdAt: Instant,
    @SerialName("updated_at") val updatedAt: Instant,
    @SerialName("pushed_at") val pushedAt: Instant?,
    val homepage: String?,
    val size: Long?,
    @SerialName("stargazers_count") val stargazersCount: Long,
    @SerialName("watchers_count") val watchersCount: Long,
    @SerialName("forks_count") val forksCount: Long,
    @SerialName("open_issues_count") val openIssuesCount: Long,
    val language: String?,
    val license: RepositoryLicenseRetrofit?,
    val topics: List<String>,
    @SerialName("default_branch") val defaultBranch: String?,
)
