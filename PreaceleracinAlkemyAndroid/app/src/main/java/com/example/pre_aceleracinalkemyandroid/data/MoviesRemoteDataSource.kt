package com.example.pre_aceleracinalkemyandroid.data

import com.example.pre_aceleracinalkemyandroid.BuildConfig
import retrofit2.Response
import retrofit2.awaitResponse
import java.lang.Exception

class MoviesRemoteDataSource {

    suspend fun getMovies() : RepositoryResult<PopularMoviesDb>{
        val service = RetrofitService.instance.create(MoviesService::class.java)
            .getPopularMovies(BuildConfig.KEY)

        try {
            val response : Response<PopularMoviesDb> = service.awaitResponse()
            val moviesDb = response.body()
            if (moviesDb != null){
                return RepositoryResult(data = moviesDb)
            }
            else{
                return RepositoryResult(errorMessage = "El serividor rechazó la operación")
            }

        }
        catch (e : Exception){

            return RepositoryResult(errorMessage = "Serividor Inaccesible")
        }
    }

    suspend fun getDetails(movieId : Int) : RepositoryResult<DetailDb>{
        val service = RetrofitService.instance.create(DetailService::class.java)
            .getDetail(movieId, BuildConfig.KEY)

        try {
            val response : Response<DetailDb> = service.awaitResponse()
            val detailDb = response.body()
            if (detailDb != null){
                return RepositoryResult(data = detailDb)
            }
            else{
                return RepositoryResult(errorMessage = "El serividor rechazó la operación")
            }
        }
        catch (e : Exception){
            return RepositoryResult(errorMessage = "El serividor rechazó la operación")
        }
    }
}