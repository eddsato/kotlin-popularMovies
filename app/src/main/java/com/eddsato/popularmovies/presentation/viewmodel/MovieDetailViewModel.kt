package com.eddsato.popularmovies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eddsato.popularmovies.AppConstants
import com.eddsato.popularmovies.model.MovieDetail
import com.eddsato.popularmovies.model.ReviewsResponse
import com.eddsato.popularmovies.model.TrailersResponse
import com.eddsato.popularmovies.repository.MovieRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MovieDetailViewModel : ViewModel(), KoinComponent {

    private val repository: MovieRepository by inject()

    fun getReviews(movieId: String): LiveData<ReviewsResponse> {
        return repository.getReviews(movieId, AppConstants.API_KEY)
    }

    fun getTrailers(movieId: String): LiveData<TrailersResponse> {
        return repository.getTrailers(movieId, AppConstants.API_KEY)
    }

    fun getMovieDetail(movieId: Int): LiveData<MovieDetail> {
        return repository.getMovieDetail(movieId, AppConstants.API_KEY)
    }
}
