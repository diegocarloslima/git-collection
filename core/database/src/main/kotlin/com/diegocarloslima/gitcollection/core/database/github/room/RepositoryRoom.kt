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

package com.diegocarloslima.gitcollection.core.database.github.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegocarloslima.gitcollection.core.database.github.model.RepositoryDatabase
import com.diegocarloslima.gitcollection.core.database.github.model.RepositoryLicenseDatabase
import com.diegocarloslima.gitcollection.core.database.github.model.RepositoryOwnerDatabase
import com.diegocarloslima.gitcollection.core.database.github.model.RepositoryTopicDatabase
import kotlinx.datetime.Instant

/**
 * This class holds data for a GitHub repository stored using Room.
 */
@Entity(
    tableName = "github_repositories",
)
internal data class RepositoryRoom(
    @PrimaryKey override val id: Long,
    override val name: String,
    override val fullName: String,
    override val owner: RepositoryOwnerDatabase,
    override val htmlUrl: String,
    override val description: String?,
    override val fork: Boolean,
    override val createdAt: Instant,
    override val updatedAt: Instant,
    override val pushedAt: Instant,
    override val homepage: String?,
    override val stargazersCount: Long,
    override val watchersCount: Long,
    override val language: String?,
    override val forksCount: Long,
    override val openIssuesCount: Long,
    override val license: RepositoryLicenseDatabase?,
    override val topics: List<RepositoryTopicDatabase>,
    override val defaultBranch: String,
) : RepositoryDatabase
