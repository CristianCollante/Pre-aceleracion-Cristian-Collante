package com.example.pre_aceleracinalkemyandroid.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.pre_aceleracinalkemyandroid.BuildConfig
import com.example.pre_aceleracinalkemyandroid.data.RepositoryResult
import com.example.pre_aceleracinalkemyandroid.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailBinding
    private val viewMoldel : DetailViewModel by viewModels(
        factoryProducer = {DetailViewModelFactory()}
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.extras?.getInt(ID_KEY)

        this.viewMoldel.detail.observe(this){detail->

                binding.tvTitle.text = detail?.title
                binding.Genre.text = detail?.genres?.get(0)?.name
                binding.tvLanguageIn.text = detail?.original_language
                binding.tvLanguage.text = detail?.spoken_languages?.get(0)?.name
                binding.rvReleaseDate.text = detail?.release_date
                binding.tvOverview.text = detail?.overview

                val urlImage = "${BuildConfig.BASE_URL_IMAGE}${detail?.backdrop_path}"
                Picasso.get().load(urlImage).into(binding.ivImage)


        }

        this.viewMoldel.loading.observe(this){ loading ->

            this.binding.progress.visibility = if (loading) View.VISIBLE else View.GONE

        }

        this.viewMoldel.error.observe(this){ errorMessage ->

            if (errorMessage != null){
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
            }
        }


        if (id != null) {
            viewMoldel.loadDetails(id)
        }
    }


}