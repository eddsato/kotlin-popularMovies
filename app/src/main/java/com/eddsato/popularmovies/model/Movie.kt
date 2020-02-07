package com.eddsato.popularmovies.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String,

    @SerializedName("id")
    @Expose
    var movieId: Int
) : Parcelable