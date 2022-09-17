package com.example.pre_aceleracinalkemyandroid.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") key : String) : Call<PopularMoviesDb>
}

interface DetailService {

    @GET("movie/{movie_id}")
    fun getDetail(@Path("movie_id") movieId: Int, @Query("api_key") key : String) : Call<DetailDb>

}