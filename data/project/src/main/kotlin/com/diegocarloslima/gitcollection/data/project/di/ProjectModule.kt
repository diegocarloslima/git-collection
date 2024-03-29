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

package com.diegocarloslima.gitcollection.data.project.di

import com.diegocarloslima.gitcollection.core.network.github.GitHubRepositoryManagerNetwork
import com.diegocarloslima.gitcollection.data.project.ProjectDataSourceRemote
import com.diegocarloslima.gitcollection.data.project.ProjectRepository
import com.diegocarloslima.gitcollection.data.project.ProjectRepositoryDefault
import com.diegocarloslima.gitcollection.data.project.remote.GitHubProjectDataSourceNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt dependency configuration for the project module.
 */
@Module
@InstallIn(SingletonComponent::class)
internal object ProjectModule {

    @Provides
    @Singleton
    fun provideProjectRepository(projectDataSourceRemote: ProjectDataSourceRemote): ProjectRepository =
        ProjectRepositoryDefault(projectDataSourceRemote)

    @Provides
    @Singleton
    fun provideProjectDataSourceRemote(
        githubRepositoryManager: GitHubRepositoryManagerNetwork,
    ): ProjectDataSourceRemote =
        GitHubProjectDataSourceNetwork(githubRepositoryManager)
}
