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

import com.diffplug.gradle.spotless.SpotlessExtension

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.protobuf) apply false
    alias(libs.plugins.spotless) apply false
}

allprojects {
    apply(plugin = rootProject.libs.plugins.spotless.get().pluginId)
    configure<SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            targetExclude("**/build/**/*.kt")
            // ktlint should be before licenseHeaderFile
            ktlint(libs.versions.ktlint.get()).userData(
                mapOf(
                    "ktlint_code_style" to "android",
                ),
            )
            licenseHeaderFile(rootProject.file("spotless/copyright.kt.txt"))
        }
        kotlinGradle {
            target("**/*.kts")
            targetExclude("**/build/**/*.kts")
            // ktlint should be before licenseHeaderFile
            ktlint(libs.versions.ktlint.get()).userData(
                mapOf(
                    "ktlint_code_style" to "android",
                ),
            )
            // Look for the first line that starts with a word or a '@' character (not a comment)
            licenseHeaderFile(rootProject.file("spotless/copyright.kts.txt"), """^[\w@]""")
        }
        format("proto") {
            target("**/*.proto")
            targetExclude("**/build/**/*.proto")
            // Look for the line with syntax definition
            licenseHeaderFile(rootProject.file("spotless/copyright.proto.txt"), """syntax""")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
        format("xml") {
            target("**/*.xml")
            targetExclude("**/build/**/*.xml")
            targetExclude(".idea/**/*.xml")
            // Look for the first XML tag that isn't a comment (<!--) or the xml declaration (<?xml)
            licenseHeaderFile(rootProject.file("spotless/copyright.xml.txt"), """<[^!?]""")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
        format("markdown") {
            target("**/*.md")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
    }
}
