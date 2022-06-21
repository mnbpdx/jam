package com.mb.jam.ui.podcastscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun PreviewPodcastScreen() {
    PodcastScreen()
}

@Composable
fun PodcastScreen(
    viewModel: PodcastScreenViewModel = viewModel()
) {

    val uiState by viewModel.state.collectAsState()

    Column {
        EpisodeList(episodes = uiState.episodes)
    }
}
