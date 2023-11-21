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

package com.diegocarloslima.gitcollection.domain.project

import androidx.paging.PagingData
import androidx.paging.map
import com.diegocarloslima.gitcollection.core.preferences.PreferencesRepository
import com.diegocarloslima.gitcollection.data.project.ProjectRepository
import com.diegocarloslima.gitcollection.domain.project.model.UserProject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

/**
 * A use case to obtain a paginated list of bookmarked [UserProject].
 */
class GetPopularUserProjectUseCase @Inject constructor(
    private val projectRepository: ProjectRepository,
    private val preferencesRepository: PreferencesRepository,
) {
    operator fun invoke(): Flow<PagingData<UserProject>> =
        combine(
            projectRepository.getPopularProjects(),
            preferencesRepository.preferences,
        ) { pagingData, preferences ->
            pagingData.map { project ->
                UserProject(project, preferences)
            }
        }
}
