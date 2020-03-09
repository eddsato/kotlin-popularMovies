package com.eddsato.popularmovies.presentation.activity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.LinearLayoutManager
import com.eddsato.popularmovies.R
import com.eddsato.popularmovies.model.Movie
import com.eddsato.popularmovies.presentation.adapter.MoviesAdapter
import com.eddsato.popularmovies.presentation.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), MoviesAdapter.OnMovieClick {
    private val adapter = MoviesAdapter(this)
    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        loadPopularMovies()
    }

    private fun setupRecyclerView() {
        rv_movies.layoutManager = LinearLayoutManager(this)
        rv_movies.adapter = adapter
    }

    private fun loadPopularMovies() {
        movieViewModel.getMovies(SORT_POPULARITY).observe(this, Observer {
            it?.let {
                var movieList: List<Movie> = it.result
                adapter.swapMovies(movieList)
            }
        })
    }

    private fun loadTopRatedMovies() {
        movieViewModel.getMovies(SORT_TOP_RATED).observe(this, Observer {
            it?.let {
                var movieList: List<Movie> = it.result
                adapter.swapMovies(movieList)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.action_popularity_filter -> {
                loadPopularMovies()
                true
            }
            R.id.action_top_rated_filter -> {
                loadTopRatedMovies()
                true
            }
            R.id.action_refresh -> {
                //refreshMovieList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onMovieClick(movie: Movie, imageView: ImageView) {
        val showMovieDetailIntent = Intent(this, MovieDetailActivity::class.java)
        val backdropImagePair = Pair.create<View, String>(imageView, getString(R.string.backdrop_transition))
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, backdropImagePair)

        showMovieDetailIntent.putExtra(INTENT_MOVIE_DETAIL, movie)
        startActivity(showMovieDetailIntent, options.toBundle())
    }

    companion object {
        private const val SORT_POPULARITY = "popular"
        private const val SORT_TOP_RATED = "top_rated"
        private const val INTENT_MOVIE_DETAIL = "movie_detail"
    }
}
