package com.mb.jam.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.mb.jam.model.Episode

@Composable
fun EpisodeList(episodes: List<Episode>) {
    LazyColumn {
        items(episodes) { episode ->  
            EpisodeCard(episode = episode)
        }
    }
}