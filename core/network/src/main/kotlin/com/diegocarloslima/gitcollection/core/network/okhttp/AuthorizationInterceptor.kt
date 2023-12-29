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

package com.diegocarloslima.gitcollection.core.network.okhttp

import com.diegocarloslima.gitcollection.core.network.util.HttpHeader
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

/**
 * An OkHttp interceptor which adds an authorization token to the requests.
 */
internal class AuthorizationInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader(HttpHeader.AUTHORIZATION, "${HttpHeader.BEARER} $token")
            .build()
        return chain.proceed(newRequest)
    }
}
