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

package com.diegocarloslima.gitcollection.core.preferences.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.diegocarloslima.gitcollection.core.preferences.model.AppPreferences
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class AppPreferencesSerializer @Inject constructor() : Serializer<AppPreferencesProto> {
    override val defaultValue: AppPreferencesProto =
        AppPreferences.DEFAULT.mapToAppPreferencesProto()

    override suspend fun readFrom(input: InputStream): AppPreferencesProto =
        try {
            AppPreferencesProto.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }

    override suspend fun writeTo(t: AppPreferencesProto, output: OutputStream) {
        t.writeTo(output)
    }
}
