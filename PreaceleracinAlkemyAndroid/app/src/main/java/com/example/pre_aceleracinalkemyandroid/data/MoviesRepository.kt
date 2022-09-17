package com.example.pre_aceleracinalkemyandroid.data

class MoviesRepository(
    private val dataSource : MoviesRemoteDataSource
) {
    suspend fun getMovies() : RepositoryResult<PopularMoviesDb> {
        return this.dataSource.getMovies()
    }

    suspend fun getDetails(movieId : Int) : RepositoryResult<DetailDb> {
        return this.dataSource.getDetails(movieId)
    }
}