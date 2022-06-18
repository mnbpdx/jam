package com.mb.jam.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mb.jam.model.Episode

@Composable
fun EpisodeList(episodes: List<Episode>) {

    val uiState = rememberEpisodeListState()

    LazyColumn {
        items(episodes) { episode ->
            EpisodeCard(episode = episode)
        }
    }
}

private class EpisodeListState

@Composable
private fun rememberEpisodeListState() = remember { EpisodeListState() }
