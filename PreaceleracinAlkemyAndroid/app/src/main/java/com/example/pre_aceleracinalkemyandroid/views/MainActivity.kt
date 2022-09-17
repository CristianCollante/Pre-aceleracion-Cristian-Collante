package com.example.pre_aceleracinalkemyandroid.views

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pre_aceleracinalkemyandroid.data.MovieDb
import com.example.pre_aceleracinalkemyandroid.databinding.ActivityMainBinding

const val ID_KEY = "id"

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private val viewMoldel : MoviesViewMoldel by viewModels(
        factoryProducer = {MoviesViewModelFactory()}
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.listMovies.layoutManager = LinearLayoutManager(this)

        this.viewMoldel.movies.observe(this) { movies ->
            this.binding.listMovies.adapter = MoviesAdapter(movies,

                object : MoviesAdapter.MovieListener{
                    override fun select(id : Int) {
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra(ID_KEY, id)
                        startActivity(intent)

                    }

                })
        }

        this.viewMoldel.loading.observe(this){ loading ->

            this.binding.progress.visibility = if (loading) View.VISIBLE else View.GONE

        }


        this.viewMoldel.error.observe(this){ errorMessage ->

            if (errorMessage != null){
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
            }
        }

        this.viewMoldel.loadMovies()

    }
}