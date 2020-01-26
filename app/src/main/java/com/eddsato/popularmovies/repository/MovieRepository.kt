package com.eddsato.popularmovies.repository

import androidx.lifecycle.MutableLiveData
import com.eddsato.popularmovies.api.MovieApi
import com.eddsato.popularmovies.api.RetrofitService
import com.eddsato.popularmovies.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MovieRepository {
    private val movieApi: MovieApi = RetrofitService.createService(MovieApi::class.java)

    fun getMovies(sort: String, apiKey: String): MutableLiveData<MovieResponse> {
        val movieData: MutableLiveData<MovieResponse> = MutableLiveData()

        movieApi.getPopularMovies(sort, apiKey).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                movieData.value = null
                Timber.i("API ERROR")
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    movieData.value = response.body()
                    Timber.i("Movie loaded from API")
                }
            }
        })
        return movieData
    }
}