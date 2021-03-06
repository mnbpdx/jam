package com.mb.jam.ui.podcastscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.text.style.TextOverflow
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
            episode = getFakeEpisode(),
            isVisible = true,
            isPlaying = false,
            togglePlayPauseButton = { }
        )
    }
}

@Composable
internal fun EpisodeCard(
    episode: Episode,
    isVisible: Boolean = true,
    isPlaying: Boolean = false,
    togglePlayPauseButton: (Boolean) -> Unit
) {

    AnimatedVisibility(visible = isVisible) {
        Surface(
            modifier = Modifier
                .fillMaxWidth().wrapContentHeight(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    EpisodeCardText(episode)
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    PlayPauseButton(
                        isPlayIcon = isPlaying,
                        onPress = togglePlayPauseButton
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
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = episode.title,
        style = MaterialTheme.typography.titleMedium,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
    Spacer(modifier = Modifier.height(4.dp))
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
