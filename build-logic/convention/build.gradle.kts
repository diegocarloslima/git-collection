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

plugins {
    `kotlin-dsl`
}

group = "com.diegocarloslima.gitcollection.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.apollo.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.protobuf.gradlePlugin)
    compileOnly(libs.secrets.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "gitcollection.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "gitcollection.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("apollo") {
            id = "gitcollection.apollo"
            implementationClass = "ApolloConventionPlugin"
        }
        register("compose") {
            id = "gitcollection.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("datastore") {
            id = "gitcollection.datastore"
            implementationClass = "DataStoreConventionPlugin"
        }
        register("hilt") {
            id = "gitcollection.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("retrofit") {
            id = "gitcollection.retrofit"
            implementationClass = "RetrofitConventionPlugin"
        }
        register("room") {
            id = "gitcollection.room"
            implementationClass = "RoomConventionPlugin"
        }
        register("secrets") {
            id = "gitcollection.secrets"
            implementationClass = "SecretsConventionPlugin"
        }
    }
}
