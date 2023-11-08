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

package com.diegocarloslima.gitcollection.ui.common.project

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.diegocarloslima.gitcollection.core.preferences.model.AppPreferences
import com.diegocarloslima.gitcollection.data.project.model.Project
import kotlinx.datetime.toInstant

/**
 * Compose preview provider for a list of [ProjectUi].
 */
internal class ProjectUiListPreviewProvider : PreviewParameterProvider<List<ProjectUi>> {
    override val values: Sequence<List<ProjectUi>> = sequenceOf(PROJECT_UI_LIST)
}

private val APP_PREFERENCES = AppPreferences.DEFAULT.copy(
    bookmarkedProjectIds = setOf(1L, 3L),
)

private val PROJECT_LIST = listOf(
    Project(
        id = 29028775L,
        owner = "facebook",
        name = "react-native",
        description = "A framework for building native applications using React",
        url = "https://github.com/facebook/react-native",
        iconUrl = "https://avatars.githubusercontent.com/u/69631?v=4",
        stars = 112328L,
        forks = 23854L,
        language = "Java",
        topics = listOf(
            "android",
            "app-framework",
            "cross-platform",
            "ios",
            "mobile",
            "mobile-development",
            "react",
            "react-native",
        ),
        updated = "2023-10-09T14:27:58Z".toInstant(),
    ),
    Project(
        id = 29028775L,
        owner = "facebook",
        name = "react-native",
        description = "A framework for building native applications using React",
        url = "https://github.com/facebook/react-native",
        iconUrl = "https://avatars.githubusercontent.com/u/69631?v=4",
        stars = 112328L,
        forks = 23854L,
        language = "Java",
        topics = listOf(
            "android",
            "app-framework",
            "cross-platform",
            "ios",
            "mobile",
            "mobile-development",
            "react",
            "react-native",
        ),
        updated = "2023-10-09T14:27:58Z".toInstant(),
    ),
)

private val PROJECT_UI_LIST = listOf(
    ProjectUi(PROJECT_LIST[0], APP_PREFERENCES),
    ProjectUi(PROJECT_LIST[1], APP_PREFERENCES),
)
