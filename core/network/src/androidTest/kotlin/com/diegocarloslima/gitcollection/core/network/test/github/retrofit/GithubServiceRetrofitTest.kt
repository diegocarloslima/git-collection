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

package com.diegocarloslima.gitcollection.core.network.test.github.retrofit

import com.diegocarloslima.gitcollection.core.network.github.GithubService
import com.diegocarloslima.gitcollection.core.network.github.retrofit.GithubServiceRetrofit
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import kotlin.test.assertEquals

/**
 * Tests for [GithubServiceRetrofit].
 */
@HiltAndroidTest
internal class GithubServiceRetrofitTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var mockWebServer: MockWebServer

    @Inject
    lateinit var githubServiceRetrofit: GithubService

//    @get:Rule
//    val testResource: TestResource = TestResource()

//    val testtest: ExternalResource = object: ExternalResource() {
//        override fun before() {
//            android.util.Log.i("GITTEST", "before Called")
//            println("GITTEST - before called")
//            super.before()
//        }
//
//        override fun after() {
//            android.util.Log.i("GITTEST", "after Called")
//            println("GITTEST - after called")
//            super.after()
//        }
//    }

    @Before
    fun setup() {
        android.util.Log.i("GITTEST", "setup Called")
        println("GITTEST - setup called")
        hiltRule.inject()
    }

    @After
    fun tearDown() {
        android.util.Log.i("GITTEST", "tearDown Called")
        println("GITTEST - tearDown called")
        mockWebServer.shutdown()
    }

    @Test
    fun test_search_repositories_success() {
        runBlocking {
//            testResource.hello()
            mockWebServer.enqueue(
                MockResponse()
                    .setResponseCode(200)
                    .setBody(SearchRepositories.BODY_SUCCESS),
            )

            val results = githubServiceRetrofit.searchRepositories(
                SearchRepositories.QUERY,
                SearchRepositories.SORT,
                SearchRepositories.ORDER,
                SearchRepositories.PER_PAGE,
                SearchRepositories.PAGE,
            )

            assertEquals(956765L, results.totalCount)
        }
    }

    @Test
    fun test_search_repositories_success2() {
        runBlocking {
//            testResource.hello()
            mockWebServer.enqueue(
                MockResponse()
                    .setResponseCode(200)
                    .setBody(SearchRepositories.BODY_SUCCESS),
            )

            val results = githubServiceRetrofit.searchRepositories(
                SearchRepositories.QUERY,
                SearchRepositories.SORT,
                SearchRepositories.ORDER,
                SearchRepositories.PER_PAGE,
                SearchRepositories.PAGE,
            )

            assertEquals(956765L, results.totalCount)
        }
    }
}
