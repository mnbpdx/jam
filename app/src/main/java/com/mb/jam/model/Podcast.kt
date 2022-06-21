package com.mb.jam.model

data class Podcast(
    val title: String,
    val episodes: List<Episode>,
    val uri: String,
    val description: String
)

fun getFakePodcast() = Podcast(
    title = "Mission To Zyxx",
    episodes = getFakeEpisodeList(),
    uri = "https://feeds.simplecast.com/ZL7iUDiH",
    description = "Placeholder description of Mission to Zyxx"
)

// This is pretty horrid, I'm still learning List functions
fun getFakeEpisodeList() =
    MutableList(3) {
        getFakeEpisode("S1 E${it + 1}")
    } + getExtraLongFakeEpisode() +
        MutableList(3) {
            getFakeEpisode("S1 E${it + 1}")
        }.toList()
