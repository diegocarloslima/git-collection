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

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private const val SETTINGS_ITEM_PADDING = 16
private const val SETTINGS_HALF_PADDING = SETTINGS_ITEM_PADDING / 2

@Composable
internal fun SettingsCategory(
    title: String,
    divider: Boolean = false,
) {
    Surface(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(SETTINGS_ITEM_PADDING.dp),
            text = title,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
        )
        if (divider) {
            Divider()
        }
    }
}

@Composable
internal fun SettingsSwitch(
    text: String,
    checked: Boolean,
    summary: String? = null,
    onCheckedChange: (Boolean) -> Unit = {},
) {
    SettingsItem(text = text, summary = summary) {
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Composable
internal fun SettingsItem(
    text: String,
    modifier: Modifier = Modifier,
    summary: String? = null,
    action: @Composable RowScope.() -> Unit = {},
) {
    Surface {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(SETTINGS_ITEM_PADDING.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = spacedBy(SETTINGS_ITEM_PADDING.dp),
        ) {
            Column(
                modifier = Modifier.weight(1F),
                verticalArrangement = spacedBy(SETTINGS_HALF_PADDING.dp),
            ) {
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
            action()
        }
    }
}
