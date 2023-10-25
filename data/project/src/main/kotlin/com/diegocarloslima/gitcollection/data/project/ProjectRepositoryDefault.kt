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

package com.diegocarloslima.gitcollection.data.project

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.diegocarloslima.gitcollection.data.project.model.Project
import com.diegocarloslima.gitcollection.data.project.paging.ProjectPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Default implementation for a repository of git projects.
 */
internal class ProjectRepositoryDefault @Inject constructor(
    private val remoteDataSource: ProjectDataSourceRemote,
) : ProjectRepository {
    override fun getPopularProjects(): Flow<PagingData<Project>> = Pager(
        config = PagingConfig(pageSize = 25, enablePlaceholders = false),
        pagingSourceFactory = { ProjectPagingSource(remoteDataSource) },
    ).flow
}
