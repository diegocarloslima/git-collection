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

package com.diegocarloslima.gitcollection.feature.settings.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingsScreen() {
    LazyColumn {
        stickyHeader {
            SettingsCategory(title = "Theming")
        }
        item {
            SettingsItem(text = "Current theme mode", summary = "Default")
        }
        item {
            SettingsItem(text = "Use dynamic colors")
        }
        stickyHeader {
            SettingsCategory(title = "Git Collection")
        }
        item {
            SettingsItem(text = "About")
        }
    }
}

@Composable
fun SettingsCategory(
    title: String,
) {
    Text(
        text = title,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleMedium,
    )
}

@Composable
fun SettingsItem(
    text: String,
    summary: String? = null,
) {
    Column {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
        )
        summary?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
