package com.example.pre_aceleracinalkemyandroid.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pre_aceleracinalkemyandroid.data.MovieDb
import com.example.pre_aceleracinalkemyandroid.data.MoviesRepository
import com.example.pre_aceleracinalkemyandroid.data.PopularMoviesDb
import com.example.pre_aceleracinalkemyandroid.data.RepositoryResult
import kotlinx.coroutines.launch

class MoviesViewMoldel (
    private val moviesRepository : MoviesRepository
) : ViewModel(){

    val movies = MutableLiveData<List<MovieDb>>()
    val loading = MutableLiveData(false)
    val error = MutableLiveData<String?>(null)

    fun loadMovies(){
        loading.value = true
        viewModelScope.launch {
            val result : RepositoryResult<PopularMoviesDb> = moviesRepository.getMovies()
            if(result.data != null){
                movies.value = result.data.results
            }
            else{
                error.value = result.errorMessage ?: "Algo salió mal"
            }
            loading.value = false
        }
    }
}