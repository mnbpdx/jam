package com.mb.jam.ui.podcastscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mb.jam.MagicEpisodeStore
import com.mb.jam.MagicPodcastRepo
import com.mb.jam.MagicPodcastStore
import com.mb.jam.model.Episode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class PodcastScreenViewModel(
    private val repo: MagicPodcastRepo,
    private val podcastStore: MagicPodcastStore,
    private val episodeStore: MagicEpisodeStore,
    private val podcastUri: String // this, along with the rest of these parameters, will change. architecture is hard.
) : ViewModel() {

    private val placeholderFlowToMakeCombineWork = MutableStateFlow(false)

    private val _state = MutableStateFlow(PodcastScreenState())
    val state: StateFlow<PodcastScreenState> = _state

    init {
        viewModelScope.launch {
            val podcast = podcastStore.getPodcast(podcastUri)

            combine(
                podcast,
                placeholderFlowToMakeCombineWork
            ) { podcast, _ ->
                PodcastScreenState(
                    episodes = podcast.episodes,
                    title = podcast.title,
                    description = podcast.description
                )
            }
        }
    }

    fun playEpisode(episode: Episode) {
        episodeStore.playEpisode(episode)
    }
}

data class PodcastScreenState(
    val episodes: List<Episode> = emptyList(),
    val title: String = "",
    val description: String = ""
)
