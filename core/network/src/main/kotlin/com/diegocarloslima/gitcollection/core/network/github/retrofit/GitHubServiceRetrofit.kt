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

package com.diegocarloslima.gitcollection.core.network.github.retrofit

import com.diegocarloslima.gitcollection.core.network.github.retrofit.model.RepositoryResultsRetrofit
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface that establishes a contract for the GitHub REST API service using Retrofit.
 *
 * @see <a href="https://docs.github.com/en/rest?apiVersion=2022-11-28>GitHub REST API documentation</a>
 */
internal interface GitHubServiceRetrofit {
    @GET(value = "search/repositories")
    suspend fun searchRepositories(
        @Query(value = "q") query: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ): RepositoryResultsRetrofit
}
