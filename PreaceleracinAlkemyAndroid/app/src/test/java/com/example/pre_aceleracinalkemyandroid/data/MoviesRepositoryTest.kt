package com.example.pre_aceleracinalkemyandroid.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock


class MoviesRepositoryTest{

    @Mock private lateinit var moviesRemoteDataSource: MoviesRemoteDataSource

    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun onBefore(){
        moviesRepository = MoviesRepository(moviesRemoteDataSource)
    }


    @Test
    fun getDetails() = runBlocking{
        //given
        c


        //when



        //then

    }


}


