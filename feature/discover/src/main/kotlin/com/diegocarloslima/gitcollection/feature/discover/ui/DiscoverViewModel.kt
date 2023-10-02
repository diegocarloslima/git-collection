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
import com.diegocarloslima.gitcollection.core.network.github.retrofit.GithubServiceRetrofit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DiscoverViewModel @Inject constructor(
    private val service: GithubServiceRetrofit,
) : ViewModel() {

    init {
        viewModelScope.launch {
            val response =
                service.searchRepositories(QUERY_TRENDING, SORT_STARS, ORDER_DESC, PER_PAGE, 1)
            android.util.Log.i("GITTEST", "response V1: ${response.isSuccessful}")
            if (response.isSuccessful) {
                response.body()?.let {
                    android.util.Log.i("GITTEST", "${it.items.size} total: ${it.totalCount}")
                    it.items.forEach { item ->
                        android.util.Log.i("GITTEST", "${item.fullName} ==> ${item.stargazersCount}")
                    }
                }
            }
        }
    }
}

// private const val QUERY_TRENDING = "android in:name,description,topics,readme language:kotlin OR android in:name,description,topics,readme language:java"
// private const val QUERY_TRENDING = "android in:name,description,topics,readme language:kotlin"
private const val QUERY_TRENDING = "android language:kotlin OR android language:java"
private const val SORT_STARS = "stars"
private const val ORDER_DESC = "desc"
private const val PER_PAGE = 100
