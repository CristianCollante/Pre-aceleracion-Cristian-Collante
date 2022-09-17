package com.example.pre_aceleracinalkemyandroid.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pre_aceleracinalkemyandroid.data.MoviesRemoteDataSource
import com.example.pre_aceleracinalkemyandroid.data.MoviesRepository

class DetailViewModelFactory : ViewModelProvider.Factory{

    @Override
    override fun <T : ViewModel> create(modelClass : Class<T>): T{

        val remoteDataSource = MoviesRemoteDataSource()
        val repository = MoviesRepository(remoteDataSource)
        val viewModel = DetailViewModel(repository)

        return viewModel as T
    }

}