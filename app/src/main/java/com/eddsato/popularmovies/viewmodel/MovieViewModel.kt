package com.eddsato.popularmovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eddsato.popularmovies.AppConstants
import com.eddsato.popularmovies.model.MovieResponse
import com.eddsato.popularmovies.repository.MovieRepository

class MovieViewModel : ViewModel() {

    private val repository: MovieRepository = MovieRepository()

    fun getMovies(sortBy: String): LiveData<MovieResponse> {
        return repository.getMovies(sortBy, AppConstants.API_KEY)
    }
}