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

package com.diegocarloslima.gitcollection.ui.project

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
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.diegocarloslima.gitcollection.domain.project.model.UserProject
import com.diegocarloslima.gitcollection.ui.common.icon.DefaultIcons
import com.diegocarloslima.gitcollection.ui.common.theme.DefaultTheme
import kotlinx.datetime.Instant
import kotlinx.datetime.toJavaInstant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import com.diegocarloslima.gitcollection.ui.strings.R as stringsR

private const val MAX_TOPICS = 5

/**
 * A card that displays information about a [UserProject].
 */
@Composable
fun ProjectCard(
    project: UserProject,
    onBookmarkClick: (projectId: Long, bookmarked: Boolean) -> Unit,
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column {
            ProjectCardTitleRow(
                project = project,
                bookmarked = project.bookmarked,
                onBookmarkClick = onBookmarkClick,
            )
            Column(
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp),
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = project.description,
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3,
                )
                Spacer(modifier = Modifier.height(8.dp))
                ProjectCardLanguageCountersRow(project)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(
                        id = stringsR.string.project_updated_on,
                        project.updated.format(),
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                )
                ProjectCardTopicsRow(project)
            }
        }
    }
}

@Composable
private fun ProjectCardTitleRow(
    project: UserProject,
    bookmarked: Boolean,
    onBookmarkClick: (projectId: Long, bookmarked: Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.padding(16.dp, 8.dp, 4.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = project.iconUrl,
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
        IconToggleButton(
            checked = bookmarked,
            onCheckedChange = { checked -> onBookmarkClick(project.id, checked) },
            content = {
                Icon(
                    imageVector = if (bookmarked) DefaultIcons.Bookmark else DefaultIcons.BookmarkBorder,
                    contentDescription = "TODO",
                )
            },
        )
    }
}

@Composable
private fun ProjectCardLanguageCountersRow(
    project: UserProject,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (project.language.isNotEmpty()) {
            Canvas(
                modifier = Modifier.size(8.dp),
            ) {
                drawCircle(color = project.languageColor)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = project.language,
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
        Icon(
            imageVector = DefaultIcons.Star,
            contentDescription = "TODO",
            modifier = Modifier.size(20.dp),
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = project.stars.toString(),
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            imageVector = DefaultIcons.AccountTree,
            contentDescription = "TODO",
            modifier = Modifier.size(20.dp),
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = project.forks.toString(),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ProjectCardTopicsRow(
    project: UserProject,
) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        project.topics.take(MAX_TOPICS).forEach { topic ->
            SuggestionChip(
                onClick = {},
                label = {
                    Text(
                        text = topic,
                        style = MaterialTheme.typography.bodySmall,
                    )
                },
            )
        }
    }
}

// TODO: Adjust and move
private fun Instant.format(): String =
    DateTimeFormatter.ofPattern("MMM d, yyyy").withZone(ZoneId.systemDefault())
        .format(this.toJavaInstant())

@Preview
@Composable
private fun ProjectCardPreview(
    @PreviewParameter(UserProjectListPreviewProvider::class)
    projects: List<UserProject>,
) {
    DefaultTheme {
        Surface {
            ProjectCard(
                project = projects[0],
                onBookmarkClick = { _, _ -> },
            )
        }
    }
}
