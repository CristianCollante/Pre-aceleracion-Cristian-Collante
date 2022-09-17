package com.example.pre_aceleracinalkemyandroid.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pre_aceleracinalkemyandroid.data.MoviesRemoteDataSource
import com.example.pre_aceleracinalkemyandroid.data.MoviesRepository

class MoviesViewModelFactory : ViewModelProvider.Factory{

    @Override
    override fun <T : ViewModel> create(modelClass : Class<T>): T{

        val remoteDataSource = MoviesRemoteDataSource()
        val repository = MoviesRepository(remoteDataSource)
        val viewModel = MoviesViewMoldel(repository)

        return viewModel as T
    }
}