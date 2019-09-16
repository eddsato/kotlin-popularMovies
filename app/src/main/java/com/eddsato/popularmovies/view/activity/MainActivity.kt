package com.eddsato.popularmovies.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import com.eddsato.popularmovies.R
import com.eddsato.popularmovies.model.Movie
import com.eddsato.popularmovies.view.GridLayoutItemDecoration
import com.eddsato.popularmovies.view.adapter.MoviesAdapter
import com.eddsato.popularmovies.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MoviesAdapter()
        rv_movies.layoutManager = GridLayoutManager(this, 2)
        rv_movies.adapter = adapter
        rv_movies.addItemDecoration(GridLayoutItemDecoration(8))

        val moviesViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        moviesViewModel.getMovies().observe(this, Observer {
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
}
