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

package com.diegocarloslima.gitcollection.core.network.github.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This class holds the data of for the results of a repository search in GitHub.
 */
@Serializable
internal data class RepositoryResultsRetrofit(
    @SerialName("total_count") val totalCount: Long,
    val items: List<RepositoryRetrofit>,
)
