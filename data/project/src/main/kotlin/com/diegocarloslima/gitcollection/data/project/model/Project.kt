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

package com.diegocarloslima.gitcollection.data.project.model

import kotlinx.datetime.Instant

/**
 * This class holds information about a Git repository project.
 */
data class Project(
    val id: Long,
    val owner: String,
    val name: String,
    val description: String,
    val url: String,
    val iconUrl: String,
    val stars: Long,
    val forks: Long,
    val language: String,
    val topics: List<String>,
    val updated: Instant,
)
