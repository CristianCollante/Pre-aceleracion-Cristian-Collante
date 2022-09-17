package com.example.pre_aceleracinalkemyandroid.data

import com.google.gson.annotations.SerializedName


data class DetailDb(
    @SerializedName("backdrop_path")
    val backdrop_path: String,

    @SerializedName("genres")
    val genres: List<Genre>,

    @SerializedName("original_language")
    val original_language: String,

    @SerializedName("spoken_languages")
    val spoken_languages : List<Lang>,

    @SerializedName("overview")
    val overview : String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("release_date")
    val release_date: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("vote_average")
    val vote_average: Double

)