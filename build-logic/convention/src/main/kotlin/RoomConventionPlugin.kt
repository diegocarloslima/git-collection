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

import com.diegocarloslima.gitcollection.buildlogic.getLibrary
import com.diegocarloslima.gitcollection.buildlogic.implementation
import com.diegocarloslima.gitcollection.buildlogic.ksp
import com.diegocarloslima.gitcollection.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class RoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                implementation(libs.getLibrary("room.runtime"))
                ksp(libs.getLibrary("room.compiler"))

                // Kotlin extensions and coroutines support
                implementation(libs.getLibrary("room.ktx"))
            }
        }
    }
}
