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

import com.diegocarloslima.gitcollection.core.network.github.model.RepositoryNetwork
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This class holds the data for a repository in GitHub.
 */
@Serializable
internal data class RepositoryRetrofit(
    override val id: Long,
    override val name: String,
    @SerialName("full_name") override val fullName: String,
    override val owner: RepositoryOwnerRetrofit,
    @SerialName("html_url") override val htmlUrl: String,
    override val description: String?,
    override val fork: Boolean,
    @SerialName("created_at") override val createdAt: Instant,
    @SerialName("updated_at") override val updatedAt: Instant,
    @SerialName("pushed_at") override val pushedAt: Instant,
    override val homepage: String?,
    @SerialName("stargazers_count") override val stargazersCount: Long,
    @SerialName("watchers_count") override val watchersCount: Long,
    override val language: String?,
    @SerialName("forks_count") override val forksCount: Long,
    @SerialName("open_issues_count") override val openIssuesCount: Long,
    override val license: RepositoryLicenseRetrofit?,
    override val topics: List<String>,
    @SerialName("default_branch") override val defaultBranch: String,
) : RepositoryNetwork
