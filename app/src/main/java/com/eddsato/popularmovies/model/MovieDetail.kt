package com.eddsato.popularmovies.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDetail (
    @SerializedName("budget")
    @Expose
    var budget: Int,

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
    var releaseDate: String,

    @SerializedName("revenue")
    @Expose
    var revenue: String,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String
): Parcelable
