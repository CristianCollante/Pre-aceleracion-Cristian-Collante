package com.example.pre_aceleracinalkemyandroid.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pre_aceleracinalkemyandroid.data.DetailDb
import com.example.pre_aceleracinalkemyandroid.data.MoviesRepository
import com.example.pre_aceleracinalkemyandroid.data.RepositoryResult
import kotlinx.coroutines.launch

class DetailViewModel(
    private val detailRepository : MoviesRepository
) : ViewModel(){

    val detail = MutableLiveData<DetailDb?>()
    val loading = MutableLiveData(false)
    val error = MutableLiveData<String?>(null)


    fun loadDetails(movieId: Int){
        loading.value = true
        viewModelScope.launch {
            val result : RepositoryResult<DetailDb> = detailRepository.getDetails(movieId)
            if(result != null){
                detail.value = result.data
            }
            else{
                error.value = result.errorMessage ?: "Algo salió mal"
            }
            loading.value = false
        }
    }


}