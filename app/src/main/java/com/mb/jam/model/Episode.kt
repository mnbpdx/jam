package com.mb.jam.model

import java.util.Date

data class Episode(
    val title: String,
    val episodeNumber: String, // needs better name. means "S1 E20" or "BONUS"
    val duration: String,
    val releaseDate: String, // could be a Date, that's formatted before going to UI, or on creation
    val isDownloaded: Boolean,
    val isPlayed: Boolean,
)

fun getFakeEpisode() = Episode(
    title = "The Whole Mufulata",
    episodeNumber = "S5 E20",
    duration = "1h 4m",
    releaseDate = "July 14",
    isDownloaded = false,
    isPlayed = false
    )