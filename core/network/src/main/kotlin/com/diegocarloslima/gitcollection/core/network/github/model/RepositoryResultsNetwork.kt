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

package com.diegocarloslima.gitcollection.core.network.github.model

/**
 * This class holds information about a repository search result in GitHub.
 *
 * @see <a href="https://docs.github.com/en/rest/search/search?apiVersion=2022-11-28#search-repositories>Search repositories</a>
 */
data class RepositoryResultsNetwork(
    val totalCount: Long,
    val items: List<RepositoryNetwork>,
    val nextKey: String? = null,
)
