package com.example.pre_aceleracinalkemyandroid.data

import com.google.gson.annotations.SerializedName

class PopularMoviesDb (
    @SerializedName("page")val page : Int,
    @SerializedName("results")val results: List<MovieDb>
)