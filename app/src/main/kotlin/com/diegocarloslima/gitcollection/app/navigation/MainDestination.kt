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

package com.diegocarloslima.gitcollection.app.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.diegocarloslima.gitcollection.ui.compose.icon.DefaultIcons
import com.diegocarloslima.gitcollection.ui.strings.R as stringsR

enum class MainDestination(
    val selectedIcon: ImageVector,
    @StringRes val iconStringRes: Int,
    @StringRes val titleStringRes: Int = iconStringRes,
) {
    DISCOVER(
        DefaultIcons.Home,
        stringsR.string.discover_title,
        titleStringRes = stringsR.string.app_name,
    ),
    SAVED(
        DefaultIcons.Favorite,
        stringsR.string.saved_title,
    ),
    SEARCH(
        DefaultIcons.Search,
        stringsR.string.search_title,
    ),
}
