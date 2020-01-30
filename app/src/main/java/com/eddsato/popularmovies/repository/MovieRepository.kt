package com.eddsato.popularmovies.repository

import androidx.lifecycle.MutableLiveData
import com.eddsato.popularmovies.api.MovieApi
import com.eddsato.popularmovies.api.RetrofitService
import com.eddsato.popularmovies.model.MovieResponse
import com.eddsato.popularmovies.model.ReviewsResponse
import com.eddsato.popularmovies.model.TrailersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MovieRepository {
    private val movieApi: MovieApi = RetrofitService.createService(MovieApi::class.java)

    fun getMovies(sort: String, apiKey: String): MutableLiveData<MovieResponse> {
        val moviesData: MutableLiveData<MovieResponse> = MutableLiveData()

        movieApi.getPopularMovies(sort, apiKey).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                moviesData.value = null
                Timber.i("API ERROR")
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    moviesData.value = response.body()
                    Timber.i("Movies data loaded from API")
                }
            }
        })
        return moviesData
    }

    fun getReviews(movieId: String, apiKey: String): MutableLiveData<ReviewsResponse> {
        val movieReviewsData: MutableLiveData<ReviewsResponse> = MutableLiveData()

        movieApi.getMovieReviews(movieId, apiKey).enqueue(object : Callback<ReviewsResponse> {
            override fun onFailure(call: Call<ReviewsResponse>, t: Throwable) {
                movieReviewsData.value = null
                Timber.i("API ERROR")
            }

            override fun onResponse(
                call: Call<ReviewsResponse>,
                response: Response<ReviewsResponse>
            ) {
                if (response.isSuccessful) {
                    movieReviewsData.value = response.body()
                    Timber.i("Movie review loaded from API")
                }
            }

        })
        return movieReviewsData
    }

    fun getTrailers(movieId: String, apiKey: String): MutableLiveData<TrailersResponse> {
        val movieTrailersData: MutableLiveData<TrailersResponse> = MutableLiveData()

        movieApi.getMovieTrailers(movieId, apiKey).enqueue(object : Callback<TrailersResponse> {
            override fun onFailure(call: Call<TrailersResponse>, t: Throwable) {
                movieTrailersData.value = null
                Timber.i("API ERROR")
            }

            override fun onResponse(
                call: Call<TrailersResponse>,
                response: Response<TrailersResponse>
            ) {
                if (response.isSuccessful) {
                    movieTrailersData.value = response.body()
                    Timber.i("Movie trailers loaded from API")
                }
            }
        })
        return movieTrailersData
    }
}