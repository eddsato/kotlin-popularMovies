package com.eddsato.popularmovies.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Review (

    @SerializedName("author")
    @Expose
    var author: String,

    @SerializedName("content")
    @Expose
    var content: String,

    @SerializedName("id")
    @Expose
    var reviewId: String,

    @SerializedName("url")
    @Expose
    var url: String
): Parcelable
