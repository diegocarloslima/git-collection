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

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.diegocarloslima.gitcollection.core.database.github.model.RepositoryDatabase
import com.diegocarloslima.gitcollection.core.database.github.model.RepositoryLicenseDatabase
import com.diegocarloslima.gitcollection.core.database.github.model.RepositoryOwnerDatabase
import com.diegocarloslima.gitcollection.core.database.github.model.RepositoryTopicDatabase
import kotlinx.datetime.Instant

/**
 * This class holds data for a GitHub repository stored using Room.
 */
internal data class RepositoryRoom(
    @Embedded val repository: RepositoryEntity,
    @Relation(parentColumn = "owner_id", entityColumn = "id")
    override val owner: RepositoryOwnerDatabase,
    @Relation(parentColumn = "license_id", entityColumn = "id")
    override val license: RepositoryLicenseDatabase?,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = RepositoryTopicCrossRef::class,
            parentColumn = "repository_id",
            entityColumn = "topic_id",
        ),
    )
    override val topics: List<RepositoryTopicDatabase>,
) : RepositoryDatabase {
    override val id: Long
        get() = repository.id
    override val name: String
        get() = repository.name
    override val fullName: String
        get() = repository.fullName
    override val htmlUrl: String
        get() = repository.htmlUrl
    override val description: String?
        get() = repository.description
    override val fork: Boolean
        get() = repository.fork
    override val createdAt: Instant
        get() = repository.createdAt
    override val updatedAt: Instant
        get() = repository.updatedAt
    override val pushedAt: Instant
        get() = repository.pushedAt
    override val homepage: String?
        get() = repository.homepage
    override val stargazersCount: Long
        get() = repository.stargazersCount
    override val watchersCount: Long
        get() = repository.watchersCount
    override val language: String?
        get() = repository.language
    override val forksCount: Long
        get() = repository.forksCount
    override val openIssuesCount: Long
        get() = repository.openIssuesCount
    override val defaultBranch: String
        get() = repository.defaultBranch
}

@Entity(
    tableName = "github_repositories",
    foreignKeys = [
        ForeignKey(
            entity = RepositoryOwnerRoom::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("owner_id"),
        ),
        ForeignKey(
            entity = RepositoryLicenseRoom::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("license_id"),
        ),
    ],
)
internal data class RepositoryEntity(
    @PrimaryKey val id: Long,
    val name: String,
    @ColumnInfo(name = "full_name")
    val fullName: String,
    @ColumnInfo(name = "owner_id")
    val ownerId: Long,
    @ColumnInfo(name = "html_url")
    val htmlUrl: String,
    val description: String?,
    val fork: Boolean,
    @ColumnInfo(name = "created_at")
    val createdAt: Instant,
    @ColumnInfo(name = "updated_at")
    val updatedAt: Instant,
    @ColumnInfo(name = "pushed_at")
    val pushedAt: Instant,
    val homepage: String?,
    @ColumnInfo(name = "stargazers_count")
    val stargazersCount: Long,
    @ColumnInfo(name = "watchers_count")
    val watchersCount: Long,
    val language: String?,
    @ColumnInfo(name = "forks_count")
    val forksCount: Long,
    @ColumnInfo(name = "open_issues_count")
    val openIssuesCount: Long,
    @ColumnInfo(name = "license_id")
    val licenseId: Long?,
    @ColumnInfo(name = "default_branch")
    val defaultBranch: String,
)

@Entity(primaryKeys = ["repository_id", "topic_id"])
internal data class RepositoryTopicCrossRef(
    @ColumnInfo(name = "repository_id")
    val repositoryId: Long,
    @ColumnInfo(name = "topic_id")
    val topicId: Long,
)
