package com.mb.jam.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mb.jam.model.Episode
import com.mb.jam.model.getFakeEpisode
import com.mb.jam.ui.theme.JamTheme

@Preview
@Composable
fun PreviewEpisodeCard() {
    JamTheme {
        EpisodeCard(
            episode = getFakeEpisode(), state = EpisodeCardState(isVisible = true)
        )
    }
}

@Composable
fun EpisodeCard(episode: Episode, state: EpisodeCardState) {
    AnimatedVisibility(visible = state.isVisible) {
        Surface(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.secondary) {
            Row {
                Column {
                    Row {
                        Text("${episode.episodeNumber} - ${episode.releaseDate}")
                    }
                    Text(
                        color = MaterialTheme.colorScheme.onSecondary,
                        text = episode.title
                    )
                    Text(episode.duration)
                }
            }
        }
    }
}

data class EpisodeCardState(val isVisible: Boolean)