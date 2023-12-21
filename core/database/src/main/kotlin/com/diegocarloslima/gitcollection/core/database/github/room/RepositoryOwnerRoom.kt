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
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegocarloslima.gitcollection.core.database.github.model.RepositoryOwnerDatabase

/**
 * This class holds data for a GitHub repository license stored using Room.
 * It has a one to many relationship with [RepositoryRoom].
 */
@Entity(
    tableName = "github_repository_owners",
)
internal data class RepositoryOwnerRoom(
    @PrimaryKey override val id: Long,
    override val login: String,
    @ColumnInfo(name = "avatar_url")
    override val avatarUrl: String,
    @ColumnInfo(name = "html_url")
    override val htmlUrl: String,
) : RepositoryOwnerDatabase
