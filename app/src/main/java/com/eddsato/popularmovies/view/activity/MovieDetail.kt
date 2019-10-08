package com.eddsato.popularmovies.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.eddsato.popularmovies.AppConstants
import com.eddsato.popularmovies.R
import com.eddsato.popularmovies.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.movies_list_item.view.*

class MovieDetail : AppCompatActivity() {
    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val bundle = intent.extras
        movie = bundle.getParcelable("movie_detail")

        movie_detail_title_tv.text = movie.title
        movie_detail_release_date_tv.text = movie.releaseDate
        movie_detail_vote_average_tv.text = movie.voteAverage.toString()
        movie_detail_overview_tv.text = movie.overview
        Picasso.with(this)
            .load(AppConstants.POSTER_BASE_URL + movie.posterPath)
            .into(movie_detail_poster_iv)
    }
}
