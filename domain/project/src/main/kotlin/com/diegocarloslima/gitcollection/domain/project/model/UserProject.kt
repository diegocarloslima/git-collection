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

package com.diegocarloslima.gitcollection.domain.project.model

import com.diegocarloslima.gitcollection.core.preferences.model.AppPreferences
import com.diegocarloslima.gitcollection.data.project.model.Project
import kotlinx.datetime.Instant

/**
 * This class holds data related to a [Project] with additional user information, such as whether
 * it's bookmarked or not.
 */
data class UserProject constructor(
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
    val bookmarked: Boolean,
) {
    constructor(project: Project, preferences: AppPreferences) : this(
        id = project.id,
        owner = project.owner,
        name = project.name,
        description = project.description,
        url = project.url,
        iconUrl = project.iconUrl,
        stars = project.stars,
        forks = project.forks,
        language = project.language,
        topics = project.topics,
        updated = project.updated,
        bookmarked = preferences.bookmarkedProjectIds.contains(project.id),
    )
}
