package com.eddsato.popularmovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eddsato.popularmovies.AppConstants
import com.eddsato.popularmovies.model.ReviewsResponse
import com.eddsato.popularmovies.model.TrailersResponse
import com.eddsato.popularmovies.repository.MovieRepository

class MovieDetailViewModel : ViewModel() {

    private val repository: MovieRepository = MovieRepository()

    fun getReviews(movieId: String): LiveData<ReviewsResponse> {
        return repository.getReviews(movieId, AppConstants.API_KEY)
    }

    fun getTrailers(movieId: String): LiveData<TrailersResponse> {
        return repository.getTrailers(movieId, AppConstants.API_KEY)
    }
}