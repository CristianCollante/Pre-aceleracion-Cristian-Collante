package com.example.pre_aceleracinalkemyandroid.data

import com.example.pre_aceleracinalkemyandroid.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val instance : Retrofit
        get() {

            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

}