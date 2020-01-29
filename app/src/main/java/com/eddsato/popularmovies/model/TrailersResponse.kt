package com.eddsato.popularmovies.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TrailersResponse(

    @SerializedName("id")
    @Expose
    var movieId: Int,

    @SerializedName("results")
    @Expose
    var results: List<Trailer>
)