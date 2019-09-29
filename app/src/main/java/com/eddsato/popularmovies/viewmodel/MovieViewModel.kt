package com.eddsato.popularmovies.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.eddsato.popularmovies.AppConstants
import com.eddsato.popularmovies.model.MovieResponse
import com.eddsato.popularmovies.repository.MovieRepository

class MovieViewModel : ViewModel() {

    private val repository: MovieRepository = MovieRepository()

    fun getMovies(sortBy: String): LiveData<MovieResponse> {
        return repository.getMovies(sortBy, AppConstants.API_KEY)
    }
}