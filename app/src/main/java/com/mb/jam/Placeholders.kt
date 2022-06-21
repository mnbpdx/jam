package com.mb.jam

import com.mb.jam.model.Episode
import com.mb.jam.model.Podcast
import kotlinx.coroutines.flow.Flow

/*
The pseudo-architecture described by the three interfaces below is almost certainly wrong,
and some of this stuff will be swapped, moved around, etc. I'm still learning large/medium
scale app architecture, and I want to focus on the UI right now. These interfaces are just
here to give my VMs some stuff to call that sorta makes sense.
 */

interface MagicPodcastRepo {
//    fun updatePodcasts()
}

interface MagicPodcastStore {
    //    fun getPodcasts(): Flow<List<Podcast>>
//    fun getSubscribedPodcasts(): List<Podcast>
//    fun playPodcast(podcastUri: String)
    fun getPodcast(uri: String): Flow<Podcast>
}

interface MagicEpisodeStore {
    fun getEpisodesOfPodcast(uri: String): Flow<List<Episode>>
    fun playEpisode(episode: Episode)
}

// val blankRepo = object : MagicPodcastRepo {}
// val blankPodcastStore = object : MagicPodcastStore {
//    override fun getPodcast(uri: String): Flow<Podcast> {
//        TODO("Not yet implemented")
//    }
// }
//
// val blankEpisodeStore = object : MagicEpisodeStore {
//    override fun getEpisodesOfPodcast(uri: String): Flow<List<Episode>> {
//        TODO("Not yet implemented")
//    }
//
// }
