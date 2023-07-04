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

import androidx.compose.foundation.clickable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role

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
    android.util.Log.i("GITTEST", "showDialog $showDialog")
    val listSummary = if (useSelectedAsSummary) {
        entries[selectedEntryIndex]
    } else {
        summary
    }
    SettingsItem(
        title = title,
        modifier = Modifier.clickable(
            enabled = enabled,
            role = Role.DropdownList,
            onClick = { showDialog = true },
        ),
        summary = listSummary,
    )
    if (!showDialog) return
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {},
        title = { Text(title) },
        text = { Text("This is text") },
    )
}
