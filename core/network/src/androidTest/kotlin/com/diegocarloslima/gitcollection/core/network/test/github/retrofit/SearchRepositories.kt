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

/**
 * HTTP Body responses for GitHub search/repositories endpoint.
 */
internal object SearchRepositories {

    const val QUERY = "android language:kotlin OR android language:java"
    const val EMPTY_QUERY = ""
    const val SORT = "stars"
    const val ORDER = "desc"
    const val PER_PAGE = 2
    const val PAGE = 1

    // From:
    // https://api.github.com/search/repositories?q=android%20language:kotlin%20OR%20android%20language:java&sort=stars&order=desc&per_page=2&page=1
    val BODY_SUCCESS = """
{
    "total_count": 956765,
    "incomplete_results": true,
    "items": [
        {
            "id": 29028775,
            "node_id": "MDEwOlJlcG9zaXRvcnkyOTAyODc3NQ==",
            "name": "react-native",
            "full_name": "facebook/react-native",
            "private": false,
            "owner": {
                "login": "facebook",
                "id": 69631,
                "node_id": "MDEyOk9yZ2FuaXphdGlvbjY5NjMx",
                "avatar_url": "https://avatars.githubusercontent.com/u/69631?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/facebook",
                "html_url": "https://github.com/facebook",
                "followers_url": "https://api.github.com/users/facebook/followers",
                "following_url": "https://api.github.com/users/facebook/following{/other_user}",
                "gists_url": "https://api.github.com/users/facebook/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/facebook/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/facebook/subscriptions",
                "organizations_url": "https://api.github.com/users/facebook/orgs",
                "repos_url": "https://api.github.com/users/facebook/repos",
                "events_url": "https://api.github.com/users/facebook/events{/privacy}",
                "received_events_url": "https://api.github.com/users/facebook/received_events",
                "type": "Organization",
                "site_admin": false
            },
            "html_url": "https://github.com/facebook/react-native",
            "description": "A framework for building native applications using React",
            "fork": false,
            "url": "https://api.github.com/repos/facebook/react-native",
            "forks_url": "https://api.github.com/repos/facebook/react-native/forks",
            "keys_url": "https://api.github.com/repos/facebook/react-native/keys{/key_id}",
            "collaborators_url": "https://api.github.com/repos/facebook/react-native/collaborators{/collaborator}",
            "teams_url": "https://api.github.com/repos/facebook/react-native/teams",
            "hooks_url": "https://api.github.com/repos/facebook/react-native/hooks",
            "issue_events_url": "https://api.github.com/repos/facebook/react-native/issues/events{/number}",
            "events_url": "https://api.github.com/repos/facebook/react-native/events",
            "assignees_url": "https://api.github.com/repos/facebook/react-native/assignees{/user}",
            "branches_url": "https://api.github.com/repos/facebook/react-native/branches{/branch}",
            "tags_url": "https://api.github.com/repos/facebook/react-native/tags",
            "blobs_url": "https://api.github.com/repos/facebook/react-native/git/blobs{/sha}",
            "git_tags_url": "https://api.github.com/repos/facebook/react-native/git/tags{/sha}",
            "git_refs_url": "https://api.github.com/repos/facebook/react-native/git/refs{/sha}",
            "trees_url": "https://api.github.com/repos/facebook/react-native/git/trees{/sha}",
            "statuses_url": "https://api.github.com/repos/facebook/react-native/statuses/{sha}",
            "languages_url": "https://api.github.com/repos/facebook/react-native/languages",
            "stargazers_url": "https://api.github.com/repos/facebook/react-native/stargazers",
            "contributors_url": "https://api.github.com/repos/facebook/react-native/contributors",
            "subscribers_url": "https://api.github.com/repos/facebook/react-native/subscribers",
            "subscription_url": "https://api.github.com/repos/facebook/react-native/subscription",
            "commits_url": "https://api.github.com/repos/facebook/react-native/commits{/sha}",
            "git_commits_url": "https://api.github.com/repos/facebook/react-native/git/commits{/sha}",
            "comments_url": "https://api.github.com/repos/facebook/react-native/comments{/number}",
            "issue_comment_url": "https://api.github.com/repos/facebook/react-native/issues/comments{/number}",
            "contents_url": "https://api.github.com/repos/facebook/react-native/contents/{+path}",
            "compare_url": "https://api.github.com/repos/facebook/react-native/compare/{base}...{head}",
            "merges_url": "https://api.github.com/repos/facebook/react-native/merges",
            "archive_url": "https://api.github.com/repos/facebook/react-native/{archive_format}{/ref}",
            "downloads_url": "https://api.github.com/repos/facebook/react-native/downloads",
            "issues_url": "https://api.github.com/repos/facebook/react-native/issues{/number}",
            "pulls_url": "https://api.github.com/repos/facebook/react-native/pulls{/number}",
            "milestones_url": "https://api.github.com/repos/facebook/react-native/milestones{/number}",
            "notifications_url": "https://api.github.com/repos/facebook/react-native/notifications{?since,all,participating}",
            "labels_url": "https://api.github.com/repos/facebook/react-native/labels{/name}",
            "releases_url": "https://api.github.com/repos/facebook/react-native/releases{/id}",
            "deployments_url": "https://api.github.com/repos/facebook/react-native/deployments",
            "created_at": "2015-01-09T18:10:16Z",
            "updated_at": "2023-10-09T20:55:15Z",
            "pushed_at": "2023-10-09T21:04:14Z",
            "git_url": "git://github.com/facebook/react-native.git",
            "ssh_url": "git@github.com:facebook/react-native.git",
            "clone_url": "https://github.com/facebook/react-native.git",
            "svn_url": "https://github.com/facebook/react-native",
            "homepage": "https://reactnative.dev",
            "size": 848625,
            "stargazers_count": 112328,
            "watchers_count": 112328,
            "language": "Java",
            "has_issues": true,
            "has_projects": true,
            "has_downloads": true,
            "has_wiki": true,
            "has_pages": true,
            "has_discussions": false,
            "forks_count": 23854,
            "mirror_url": null,
            "archived": false,
            "disabled": false,
            "open_issues_count": 1640,
            "license": {
                "key": "mit",
                "name": "MIT License",
                "spdx_id": "MIT",
                "url": "https://api.github.com/licenses/mit",
                "node_id": "MDc6TGljZW5zZTEz"
            },
            "allow_forking": true,
            "is_template": false,
            "web_commit_signoff_required": false,
            "topics": [
                "android",
                "app-framework",
                "cross-platform",
                "ios",
                "mobile",
                "mobile-development",
                "react",
                "react-native"
            ],
            "visibility": "public",
            "forks": 23854,
            "open_issues": 1640,
            "watchers": 112328,
            "default_branch": "main",
            "score": 1
        },
        {
            "id": 5152285,
            "node_id": "MDEwOlJlcG9zaXRvcnk1MTUyMjg1",
            "name": "okhttp",
            "full_name": "square/okhttp",
            "private": false,
            "owner": {
                "login": "square",
                "id": 82592,
                "node_id": "MDEyOk9yZ2FuaXphdGlvbjgyNTky",
                "avatar_url": "https://avatars.githubusercontent.com/u/82592?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/square",
                "html_url": "https://github.com/square",
                "followers_url": "https://api.github.com/users/square/followers",
                "following_url": "https://api.github.com/users/square/following{/other_user}",
                "gists_url": "https://api.github.com/users/square/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/square/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/square/subscriptions",
                "organizations_url": "https://api.github.com/users/square/orgs",
                "repos_url": "https://api.github.com/users/square/repos",
                "events_url": "https://api.github.com/users/square/events{/privacy}",
                "received_events_url": "https://api.github.com/users/square/received_events",
                "type": "Organization",
                "site_admin": false
            },
            "html_url": "https://github.com/square/okhttp",
            "description": "Square’s meticulous HTTP client for the JVM, Android, and GraalVM.",
            "fork": false,
            "url": "https://api.github.com/repos/square/okhttp",
            "forks_url": "https://api.github.com/repos/square/okhttp/forks",
            "keys_url": "https://api.github.com/repos/square/okhttp/keys{/key_id}",
            "collaborators_url": "https://api.github.com/repos/square/okhttp/collaborators{/collaborator}",
            "teams_url": "https://api.github.com/repos/square/okhttp/teams",
            "hooks_url": "https://api.github.com/repos/square/okhttp/hooks",
            "issue_events_url": "https://api.github.com/repos/square/okhttp/issues/events{/number}",
            "events_url": "https://api.github.com/repos/square/okhttp/events",
            "assignees_url": "https://api.github.com/repos/square/okhttp/assignees{/user}",
            "branches_url": "https://api.github.com/repos/square/okhttp/branches{/branch}",
            "tags_url": "https://api.github.com/repos/square/okhttp/tags",
            "blobs_url": "https://api.github.com/repos/square/okhttp/git/blobs{/sha}",
            "git_tags_url": "https://api.github.com/repos/square/okhttp/git/tags{/sha}",
            "git_refs_url": "https://api.github.com/repos/square/okhttp/git/refs{/sha}",
            "trees_url": "https://api.github.com/repos/square/okhttp/git/trees{/sha}",
            "statuses_url": "https://api.github.com/repos/square/okhttp/statuses/{sha}",
            "languages_url": "https://api.github.com/repos/square/okhttp/languages",
            "stargazers_url": "https://api.github.com/repos/square/okhttp/stargazers",
            "contributors_url": "https://api.github.com/repos/square/okhttp/contributors",
            "subscribers_url": "https://api.github.com/repos/square/okhttp/subscribers",
            "subscription_url": "https://api.github.com/repos/square/okhttp/subscription",
            "commits_url": "https://api.github.com/repos/square/okhttp/commits{/sha}",
            "git_commits_url": "https://api.github.com/repos/square/okhttp/git/commits{/sha}",
            "comments_url": "https://api.github.com/repos/square/okhttp/comments{/number}",
            "issue_comment_url": "https://api.github.com/repos/square/okhttp/issues/comments{/number}",
            "contents_url": "https://api.github.com/repos/square/okhttp/contents/{+path}",
            "compare_url": "https://api.github.com/repos/square/okhttp/compare/{base}...{head}",
            "merges_url": "https://api.github.com/repos/square/okhttp/merges",
            "archive_url": "https://api.github.com/repos/square/okhttp/{archive_format}{/ref}",
            "downloads_url": "https://api.github.com/repos/square/okhttp/downloads",
            "issues_url": "https://api.github.com/repos/square/okhttp/issues{/number}",
            "pulls_url": "https://api.github.com/repos/square/okhttp/pulls{/number}",
            "milestones_url": "https://api.github.com/repos/square/okhttp/milestones{/number}",
            "notifications_url": "https://api.github.com/repos/square/okhttp/notifications{?since,all,participating}",
            "labels_url": "https://api.github.com/repos/square/okhttp/labels{/name}",
            "releases_url": "https://api.github.com/repos/square/okhttp/releases{/id}",
            "deployments_url": "https://api.github.com/repos/square/okhttp/deployments",
            "created_at": "2012-07-23T13:42:55Z",
            "updated_at": "2023-10-09T14:27:58Z",
            "pushed_at": "2023-10-09T08:09:32Z",
            "git_url": "git://github.com/square/okhttp.git",
            "ssh_url": "git@github.com:square/okhttp.git",
            "clone_url": "https://github.com/square/okhttp.git",
            "svn_url": "https://github.com/square/okhttp",
            "homepage": "https://square.github.io/okhttp/",
            "size": 48555,
            "stargazers_count": 44559,
            "watchers_count": 44559,
            "language": "Kotlin",
            "has_issues": true,
            "has_projects": false,
            "has_downloads": true,
            "has_wiki": false,
            "has_pages": true,
            "has_discussions": false,
            "forks_count": 9224,
            "mirror_url": null,
            "archived": false,
            "disabled": false,
            "open_issues_count": 110,
            "license": {
                "key": "apache-2.0",
                "name": "Apache License 2.0",
                "spdx_id": "Apache-2.0",
                "url": "https://api.github.com/licenses/apache-2.0",
                "node_id": "MDc6TGljZW5zZTI="
            },
            "allow_forking": true,
            "is_template": false,
            "web_commit_signoff_required": false,
            "topics": [
                "android",
                "graalvm",
                "java",
                "kotlin"
            ],
            "visibility": "public",
            "forks": 9224,
            "open_issues": 110,
            "watchers": 44559,
            "default_branch": "master",
            "score": 1
        }
    ]
}
    """.trimIndent()

    // From:
    // https://api.github.com/search/repositories?q=&sort=stars&order=desc&per_page=2&page=1
    val BODY_EMPTY_QUERY = """
{
  "message": "Validation Failed",
  "errors": [
    {
      "resource": "Search",
      "field": "q",
      "code": "missing"
    }
  ],
  "documentation_url": "https://docs.github.com/v3/search"
}
    """.trimIndent()
}
