package com.eddsato.popularmovies.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.eddsato.popularmovies.R
import com.eddsato.popularmovies.model.Movie
import com.eddsato.popularmovies.view.GridLayoutItemDecoration
import com.eddsato.popularmovies.view.adapter.MoviesAdapter
import com.eddsato.popularmovies.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MoviesAdapter.OnMovieClick {

    private val adapter = MoviesAdapter(this)
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        loadPopularMovies()
    }

    private fun setupRecyclerView() {
        rv_movies.layoutManager = GridLayoutManager(this, 2)
        rv_movies.adapter = adapter
        rv_movies.addItemDecoration(GridLayoutItemDecoration(8))
    }

    private fun loadPopularMovies() {
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieViewModel.getMovies(SORT_POPULARITY).observe(this, Observer {
            it?.let {
                var movieList: List<Movie> = it.result
                adapter.swapMovies(movieList)
            }
        })
    }

    private fun loadTopRatedMovies() {
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
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

    override fun onMovieClick(movie: Movie) {
        val showMovieDetailIntent = Intent(this, MovieDetail::class.java)
        showMovieDetailIntent.putExtra(INTENT_MOVIE_DETAIL, movie)
        startActivity(showMovieDetailIntent)
    }

    companion object {
        const val SORT_POPULARITY = "popular"
        const val SORT_TOP_RATED = "top_rated"
        const val INTENT_MOVIE_DETAIL = "movie_detail"
    }
}
