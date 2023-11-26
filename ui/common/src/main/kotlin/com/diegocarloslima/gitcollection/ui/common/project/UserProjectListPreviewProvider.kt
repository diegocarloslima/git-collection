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
import com.diegocarloslima.gitcollection.domain.project.model.UserProject
import kotlinx.datetime.toInstant

/**
 * Compose preview provider for a list of [UserProject].
 */
internal class UserProjectListPreviewProvider : PreviewParameterProvider<List<UserProject>> {
    override val values: Sequence<List<UserProject>> = sequenceOf(USER_PROJECT_LIST)
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
        stars = 112737L,
        forks = 23952L,
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
        updated = "2023-11-10T09:58:51Z".toInstant(),
    ),
    Project(
        id = 5152285L,
        owner = "square",
        name = "okhttp",
        description = "Square’s meticulous HTTP client for the JVM, Android, and GraalVM.",
        url = "https://github.com/square/okhttp",
        iconUrl = "https://avatars.githubusercontent.com/u/82592?v=4",
        stars = 44690L,
        forks = 9254L,
        language = "Kotlin",
        topics = listOf(
            "android",
            "graalvm",
            "java",
            "kotlin",
        ),
        updated = "2023-11-10T08:18:46Z".toInstant(),
    ),
    Project(
        id = 51148780L,
        owner = "android",
        name = "architecture-samples",
        description = "A collection of samples to discuss and showcase different architectural tools and patterns for Android apps.",
        url = "https://github.com/android/architecture-samples",
        iconUrl = "https://avatars.githubusercontent.com/u/32689599?v=4",
        stars = 43290L,
        forks = 11588L,
        language = "Kotlin",
        topics = listOf(
            "android",
            "android-architecture",
            "samples",
        ),
        updated = "2023-11-10T08:42:49Z".toInstant(),
    ),
)

private val USER_PROJECT_LIST = listOf(
    UserProject(PROJECT_LIST[0], APP_PREFERENCES),
    UserProject(PROJECT_LIST[1], APP_PREFERENCES),
)
