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

import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.VersionConstraint
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun VersionCatalog.getVersion(alias: String): VersionConstraint =
    this.findVersion(alias).get()

internal fun VersionCatalog.getLibrary(alias: String): Provider<MinimalExternalModuleDependency> =
    this.findLibrary(alias).get()

internal fun VersionCatalog.getBundle(alias: String): Provider<ExternalModuleDependencyBundle> =
    this.findBundle(alias).get()

internal fun VersionCatalog.getPlugin(alias: String): Provider<PluginDependency> =
    this.findPlugin(alias).get()

internal fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

internal fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

internal fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)
internal fun DependencyHandler.ksp(dependencyNotation: Any): Dependency? =
    add("ksp", dependencyNotation)

internal fun DependencyHandler.kspTest(dependencyNotation: Any): Dependency? =
    add("kspTest", dependencyNotation)

internal fun DependencyHandler.coreLibraryDesugaring(dependencyNotation: Any): Dependency? =
    add("coreLibraryDesugaring", dependencyNotation)
