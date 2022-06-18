package com.mb.jam.model

data class Podcast(
    val title: String,
    val episodes: List<Episode>
)

fun getFakePodcast() = Podcast(title = "Mission To Zyxx", episodes = getFakeEpisodeList())

// This is pretty horrid, I'm still learning List functions
fun getFakeEpisodeList() =
    MutableList(3) {
        getFakeEpisode("S1 E${it + 1}")
    } + getExtraLongFakeEpisode() +
        MutableList(3) {
            getFakeEpisode("S1 E${it + 1}")
        }.toList()
