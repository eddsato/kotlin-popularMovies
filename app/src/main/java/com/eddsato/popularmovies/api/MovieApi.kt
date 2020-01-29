package com.eddsato.popularmovies.api

import com.eddsato.popularmovies.model.MovieResponse
import com.eddsato.popularmovies.model.ReviewsResponse
import com.eddsato.popularmovies.model.TrailersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{sort}")
    fun getPopularMovies(
        @Path("sort") sort: String,
        @Query("api_key") apiKey: String
    ): Call<MovieResponse>

    @GET("movie/{movie_id}/reviews")
    fun getMovieReviews(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String
    ): Call<ReviewsResponse>

    @GET("movie/{movie_id}/videos")
    fun getMovieTrailers(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String
    ): Call<TrailersResponse>
}