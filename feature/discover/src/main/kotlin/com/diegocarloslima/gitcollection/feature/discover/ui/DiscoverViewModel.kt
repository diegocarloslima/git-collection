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

package com.diegocarloslima.gitcollection.feature.discover.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.diegocarloslima.gitcollection.core.preferences.PreferencesRepository
import com.diegocarloslima.gitcollection.domain.project.GetPopularUserProjectsUseCase
import com.diegocarloslima.gitcollection.domain.project.model.UserProject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the Discover screen.
 */
@HiltViewModel
internal class DiscoverViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository,
    getPopularUserProjects: GetPopularUserProjectsUseCase,
) : ViewModel() {

    val popularProjects: Flow<PagingData<UserProject>> =
        getPopularUserProjects()

    fun updateProjectBookmarked(projectId: Long, bookmarked: Boolean) {
        android.util.Log.i("GITTEST", "ViewModel bookmarked: $projectId $bookmarked")
        viewModelScope.launch {
            preferencesRepository.updateProjectBookmarked(projectId, bookmarked)
        }
    }
}
