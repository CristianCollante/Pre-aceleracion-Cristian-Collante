package com.example.pre_aceleracinalkemyandroid.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pre_aceleracinalkemyandroid.BuildConfig
import com.example.pre_aceleracinalkemyandroid.data.MovieDb
import com.example.pre_aceleracinalkemyandroid.databinding.ListItemMoviesBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.selects.select

class MoviesAdapter(
    private val movies : List<MovieDb>,
    private val listener : MovieListener? = null

) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    interface MovieListener{
        fun select(id : Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemMoviesBinding.inflate(layoutInflater)

        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MoviesViewHolder(
        private val binding : ListItemMoviesBinding
    ):RecyclerView.ViewHolder(binding.root){

        fun bind(movie : MovieDb){
            this.binding.textViewTitle.text = movie.title
            val urlImage = "${BuildConfig.BASE_URL_IMAGE}${movie.poster}"
            Picasso.get().load(urlImage).into(binding.portada)

            binding.root.setOnClickListener(){
                listener?.select(movie.id)
            }
        }

    }


}