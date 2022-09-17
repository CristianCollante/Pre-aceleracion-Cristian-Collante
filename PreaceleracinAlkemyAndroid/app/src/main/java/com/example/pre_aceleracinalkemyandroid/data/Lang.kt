package com.example.pre_aceleracinalkemyandroid.data

import com.google.gson.annotations.SerializedName

data class Lang(

    @SerializedName("english_name")
    val english_name: String,

    @SerializedName("iso_639_1")
    val iso_639_1: String,

    @SerializedName("name")
    val name: String,
)
