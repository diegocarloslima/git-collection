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

package com.diegocarloslima.gitcollection.feature.discover.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.diegocarloslima.gitcollection.data.project.model.Project
import com.diegocarloslima.gitcollection.ui.compose.icon.DefaultIcons
import kotlinx.datetime.Instant
import kotlinx.datetime.toJavaInstant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import com.diegocarloslima.gitcollection.ui.strings.R as stringsR

// TODO: Move
@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun DiscoverProjectCard(
    project: Project,
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Row {
                Icon(
                    imageVector = DefaultIcons.Home,
                    contentDescription = "TODO",
                    modifier = Modifier.size(32.dp),
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text(text = project.owner, style = MaterialTheme.typography.bodySmall)
                    Text(text = project.name, style = MaterialTheme.typography.titleSmall)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = DefaultIcons.BookmarkBorder,
                    contentDescription = "TODO",
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Canvas(
                    modifier = Modifier
                        .size(8.dp)
                        .align(Alignment.CenterVertically),
                ) {
                    drawCircle(color = Color.Blue)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = project.language,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = DefaultIcons.Star,
                    contentDescription = "TODO",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically),
                )
                Text(
                    text = project.stars.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = DefaultIcons.AccountTree,
                    contentDescription = "TODO",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically),
                )
                Text(
                    text = project.forks.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(
                    id = stringsR.string.project_updated_on,
                    project.updated.format(),
                ),
                style = MaterialTheme.typography.bodyMedium,
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                project.topics.forEach { topic ->
                    SuggestionChip(onClick = { /*TODO*/ }, label = {
                        Text(
                            text = topic,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    })
                }
            }
        }
    }
}

// TODO: Adjust and move
private fun Instant.format(): String =
    DateTimeFormatter.ofPattern("MMM d, yyyy").withZone(ZoneId.systemDefault())
        .format(this.toJavaInstant())
