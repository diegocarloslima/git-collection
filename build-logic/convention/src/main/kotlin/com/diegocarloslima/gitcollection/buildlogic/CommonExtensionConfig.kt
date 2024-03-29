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

package com.diegocarloslima.gitcollection.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

internal fun Project.configureCommonAndroid(commonExtension: CommonExtension<*, *, *, *, *>) {
    with(pluginManager) {
        apply("org.jetbrains.kotlin.android")
    }

    commonExtension.apply {
        compileSdk = BuildConfig.Android.COMPILE_SDK

        defaultConfig {
            minSdk = BuildConfig.Android.MIN_SDK
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = BuildConfig.Java.VERSION
            targetCompatibility = BuildConfig.Java.VERSION
            isCoreLibraryDesugaringEnabled = true
        }

        kotlinOptions {
            jvmTarget = BuildConfig.Java.VERSION.toString()
        }

        dependencies {
            val kotlinTest = kotlin("test")
            coreLibraryDesugaring(libs.getLibrary("android.desugar.jdk.libs"))

            testImplementation(kotlinTest)

            androidTestImplementation(kotlinTest)
            androidTestImplementation(libs.getLibrary("androidx.test.runner"))
        }
    }
}
