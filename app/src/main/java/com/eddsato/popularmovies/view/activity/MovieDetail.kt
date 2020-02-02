package com.eddsato.popularmovies.view.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        movie = bundle.getParcelable("movie_detail")

        setupViewsValues()
    }

    private fun setupViewsValues() {
        movie_detail_title_tv.text = movie.title
        movie_detail_release_date_tv.text = movie.releaseDate
        movie_detail_vote_average_tv.text = movie.voteAverage.toString()
        movie_detail_overview_tv.text = movie.overview
        tb_detail.title = movie.title
        tb_detail.setExpandedTitleColor(Color.parseColor("#FFFFFF"))
        tb_detail.setCollapsedTitleTextColor(Color.parseColor("#FFFFFF"))
        Picasso.with(this)
            .load(AppConstants.POSTER_BASE_URL + movie.backdropPath)
            .into(iv_backdrop_image)
        Picasso.with(this)
            .load(AppConstants.POSTER_BASE_URL + movie.posterPath)
            .into(movie_detail_poster_iv)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            //to reverse the scene transition animation
            supportFinishAfterTransition()
        }
        return super.onOptionsItemSelected(item)
    }
}
