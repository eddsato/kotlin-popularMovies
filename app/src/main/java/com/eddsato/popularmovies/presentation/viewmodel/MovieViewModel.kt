package com.eddsato.popularmovies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eddsato.popularmovies.AppConstants
import com.eddsato.popularmovies.model.MoviesResponse
import com.eddsato.popularmovies.repository.MovieRepository

class MovieViewModel : ViewModel() {

    private val repository: MovieRepository = MovieRepository()

    fun getMovies(sortBy: String): LiveData<MoviesResponse> {
        return repository.getMovies(sortBy, AppConstants.API_KEY)
    }
}
