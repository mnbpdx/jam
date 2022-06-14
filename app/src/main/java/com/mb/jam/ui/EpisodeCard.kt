package com.mb.jam.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mb.jam.model.Episode
import com.mb.jam.model.getFakeEpisode
import com.mb.jam.ui.theme.JamTheme


@Preview
@Composable
fun PreviewEpisodeCard() {
    JamTheme {
        EpisodeCard(
            episode = getFakeEpisode(),
            state = EpisodeCardState(isVisible = true, isPlaying = false)
        )
    }
}


@Composable
fun EpisodeCard(episode: Episode, state: EpisodeCardState) {

    AnimatedVisibility(visible = state.isVisible) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Row() {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(start = 8.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${episode.episodeNumber} - ${episode.releaseDate}",
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = episode.title, style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = episode.duration,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    if (state.isPlaying) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = "Play Arrow Icon"
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.Pause,
                            contentDescription = "Pause Icon"
                        )
                    }
                }
            }
        }
    }
}

data class EpisodeCardState(val isVisible: Boolean, val isPlaying: Boolean)