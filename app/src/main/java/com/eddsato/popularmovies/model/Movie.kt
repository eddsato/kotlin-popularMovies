package com.eddsato.popularmovies.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// 9888ffb41d50cb4a3a1e1a567a20f59a

data class Movie (
    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("poster_path")
    @Expose
    var posterPath: String,

    @SerializedName("overview")
    @Expose
    var overview: String,

    @SerializedName("vote_avarage")
    @Expose
    var voteAverage: Number,

    @SerializedName("release_date")
    @Expose
    var releaseDate: String
)