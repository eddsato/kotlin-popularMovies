package com.eddsato.popularmovies.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ReviewsResponse (

    @SerializedName("id")
    @Expose
    var movieId: Int,

    @SerializedName("page")
    @Expose
    var page: Int,

    @SerializedName("results")
    @Expose
    var results: List<Review>,

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int,

    @SerializedName("total_results")
    @Expose
    var totalResults: Int
)