package com.eddsato.popularmovies.api

import com.eddsato.popularmovies.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{sort}")
    fun getPopularMovies(
        @Path("sort") sort: String,
        @Query("api_key") apiKey: String
    ): Call<MoviesResponse>

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

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Call<MovieDetail>
}