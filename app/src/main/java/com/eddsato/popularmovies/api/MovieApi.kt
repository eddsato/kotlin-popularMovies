package com.eddsato.popularmovies.api

import com.eddsato.popularmovies.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{sort}")
    fun getPopularMovies(
        @Path("sort") sort: String,
        @Query("api_key") apiKey: String ): Call<MovieResponse>
}