package com.eddsato.popularmovies.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

// 9888ffb41d50cb4a3a1e1a567a20f59a

@Parcelize
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

    @SerializedName("vote_average")
    @Expose
    var voteAverage: Number,

    @SerializedName("release_date")
    @Expose
    var releaseDate: String
) : Parcelable