package com.eddsato.popularmovies.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.eddsato.popularmovies.AppConstants
import com.eddsato.popularmovies.model.MovieResponse
import com.eddsato.popularmovies.repository.MovieRepository

class MovieViewModel : ViewModel() {

    private val repository: MovieRepository = MovieRepository()

    fun getMovies(): LiveData<MovieResponse> {
        return repository.getMovies(SORT_TOP_RATED, AppConstants.API_KEY)

    }

    companion object {
        const val SORT_POPULARITY = "popular"
        const val SORT_TOP_RATED = "top_rated"
    }
}