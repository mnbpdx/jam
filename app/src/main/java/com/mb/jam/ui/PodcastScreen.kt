package com.mb.jam.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mb.jam.model.Podcast
import com.mb.jam.model.getFakePodcast

@Preview
@Composable
fun PreviewPodcastScreen() {
    PodcastScreen(podcast = getFakePodcast())
}

@Composable
fun PodcastScreen(podcast: Podcast) {
    Column {
        EpisodeList(episodes = podcast.episodes)
    }
}
