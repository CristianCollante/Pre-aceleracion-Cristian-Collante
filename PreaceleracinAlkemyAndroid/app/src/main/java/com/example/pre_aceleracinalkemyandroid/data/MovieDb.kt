package com.example.pre_aceleracinalkemyandroid.data

import com.google.gson.annotations.SerializedName

data class MovieDb(
    @SerializedName("title")
    val title : String,
    @SerializedName("poster_path")
    val poster : String,
    @SerializedName("backdrop_path")
    val backdrop : String,
    @SerializedName("id")
    val id : Int
   /* @SerializedName("original_language")
    val language : String,
    @SerializedName("popularity")
    val popularity : Double,
    @SerializedName("release_date")
    val release_date : String,
    @SerializedName("vote_average")
    val vote_average : Double*/
    )


