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

import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

private const val SETTINGS_ITEM_PADDING = 16
private const val SETTINGS_HALF_PADDING = SETTINGS_ITEM_PADDING / 2

@Composable
internal fun SettingsCategory(
    title: String,
    divider: Boolean = false,
) {
    ListItem(
        headlineContent = {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
            )
        },
    )
    if (divider) {
        Divider()
    }
}

@Composable
internal fun SettingsList() {
}

@Composable
internal fun SettingsSwitch(
    text: String,
    checked: Boolean,
    summary: String? = null,
    onCheckedChange: (Boolean) -> Unit = {},
) {
    SettingsItem(title = text, summary = summary) {
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Composable
internal fun SettingsItem(
    title: String,
    modifier: Modifier = Modifier,
    summary: String? = null,
    icon: @Composable (() -> Unit)? = null,
    action: @Composable (() -> Unit)? = null,
) {
    ListItem(
        headlineContent = { Text(text = title) },
        modifier = modifier,
        supportingContent = summary?.let { { Text(text = it) } },
        leadingContent = icon?.let { { it() } },
        trailingContent = action?.let { { it() } },
    )
}
