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

package com.diegocarloslima.gitcollection.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.diegocarloslima.gitcollection.app.ui.MainUiState.Loading
import com.diegocarloslima.shortkuts.compat.setDecorFitsSystemWindowsCompat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Should be called before onCreate and setContent
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.uiState.value == Loading
        }

        super.onCreate(savedInstanceState)

        // Turning off the decor view fitting system windows.
        // This makes the app in control on how to handle window insets, allowing us to draw behind
        // the system UI and animate synchronously with the software keyboard.
        window.setDecorFitsSystemWindowsCompat(false)

        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            MainContent(uiState = uiState)
        }
    }
}
