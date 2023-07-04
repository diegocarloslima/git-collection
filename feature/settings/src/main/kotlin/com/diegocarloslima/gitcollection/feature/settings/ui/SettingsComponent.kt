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

import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
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
internal fun SettingsListSingle(
    title: String,
    entries: List<String>,
    selectedEntryIndex: Int,
    summary: String? = null,
    useSelectedAsSummary: Boolean = true,
    enabled: Boolean = true,
    onEntrySelected: ((Int, String) -> Unit)? = null,
) {
    if (selectedEntryIndex > entries.size) {
        throw IndexOutOfBoundsException("Selected entry index: $selectedEntryIndex is greater than entries size: ${entries.size}")
    }
    var showDialog by rememberSaveable { mutableStateOf(false) }
    val listSummary = if (useSelectedAsSummary) {
        entries[selectedEntryIndex]
    } else {
        summary
    }
    SettingsItem(title = title, summary = listSummary)
}

@Composable
internal fun SettingsSwitch(
    title: String,
    checked: Boolean,
    summary: String? = null,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = {},
) {
    SettingsItem(
        title = title,
        modifier = Modifier.toggleable(
            value = checked,
            enabled = enabled,
            role = Role.Checkbox,
            onValueChange = onCheckedChange
        ),
        summary = summary,
    ) {
        Switch(checked = checked, onCheckedChange = onCheckedChange, enabled = enabled)
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
