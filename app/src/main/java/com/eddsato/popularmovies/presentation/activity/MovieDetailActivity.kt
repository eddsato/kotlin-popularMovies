package com.eddsato.popularmovies.presentation.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eddsato.popularmovies.AppConstants
import com.eddsato.popularmovies.R
import com.eddsato.popularmovies.model.Movie
import com.eddsato.popularmovies.presentation.viewmodel.MovieDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var movie: Movie
    private val movieDetailViewModel: MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        movie = bundle.getParcelable("movie_detail")

        loadBackdropImageFromTransition()
        loadMovieDetail()
    }

    private fun loadMovieDetail() {
        movieDetailViewModel.getMovieDetail(movie.movieId).observe(this, Observer {
            it?.let {
                movie_detail_title_tv.text = movie.title
                movie_detail_release_date_tv.text = it.releaseDate
                movie_detail_vote_average_tv.text = it.voteAverage.toString()
                movie_detail_overview_tv.text = it.overview
                tb_detail.title = it.title
                tb_detail.setExpandedTitleColor(Color.parseColor("#FFFFFF"))
                tb_detail.setCollapsedTitleTextColor(Color.parseColor("#FFFFFF"))
                Picasso.with(this)
                    .load(AppConstants.POSTER_BASE_URL + it.posterPath)
                    .into(movie_detail_poster_iv)
            }
        })
    }

    private fun loadBackdropImageFromTransition() {
        Picasso.with(this)
            .load(AppConstants.POSTER_BASE_URL + movie.backdropPath)
            .into(iv_backdrop_image)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            supportFinishAfterTransition()
        }
        return super.onOptionsItemSelected(item)
    }
}
