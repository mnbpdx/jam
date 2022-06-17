package com.mb.jam.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mb.jam.model.Episode
import com.mb.jam.model.getFakeEpisode
import com.mb.jam.ui.theme.JamTheme

@Preview
@Composable
private fun PreviewEpisodeCard() {
    JamTheme {
        EpisodeCard(
            episode = getFakeEpisode()
        )
    }
}

@Composable
internal fun EpisodeCard(episode: Episode) {

    val uiState = rememberEpisodeCardState()

    AnimatedVisibility(visible = uiState.isVisible) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(start = 8.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    EpisodeCardText(episode)
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    PlayPauseButton(
                        isPlayIcon = uiState.isPlaying,
                        onPress = uiState::togglePlayPauseButton
                    )
                }
            }
        }
    }
}

@Composable
private fun EpisodeCardText(episode: Episode) {
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

@Composable
private fun PlayPauseButton(isPlayIcon: Boolean, onPress: (Boolean) -> Unit) {
    if (isPlayIcon) {
        Icon(
            modifier = Modifier.clickable { onPress(isPlayIcon) },
            imageVector = Icons.Filled.PlayArrow,
            contentDescription = "Play Arrow Icon"
        )
    } else {
        Icon(
            modifier = Modifier.clickable { onPress(isPlayIcon) },
            imageVector = Icons.Filled.Pause,
            contentDescription = "Pause Icon"
        )
    }
}

private class EpisodeCardState {

    var isVisible by mutableStateOf(true)
        private set

    var isPlaying by mutableStateOf(false)
        private set

    fun togglePlayPauseButton(currentState: Boolean) {
        isPlaying = !currentState
    }
}

@Composable
private fun rememberEpisodeCardState() = remember { EpisodeCardState() }
