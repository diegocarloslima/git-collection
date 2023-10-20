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

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegocarloslima.gitcollection.data.project.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DiscoverViewModel @Inject constructor(
    private val projectRepository: ProjectRepository,
) : ViewModel() {

    init {
        Log.i("GITTEST", "searchRepositories V1")
        viewModelScope.launch {
            try {
                projectRepository.getPopularProjects(1).forEach { project ->
                    Log.i("GITTEST", "project: ${project.name} ==> ${project.stars}")
                }
            } catch (t: Throwable) {
                Log.e(
                    "GITTEST",
                    "${t::class.java.name} error happened: ${Log.getStackTraceString(t)}",
                )
            }
        }
    }
}
