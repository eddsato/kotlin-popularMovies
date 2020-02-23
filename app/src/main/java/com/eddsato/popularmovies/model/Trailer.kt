package com.eddsato.popularmovies.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Trailer(

    @SerializedName("key")
    @Expose
    var key: String,

    @SerializedName("site")
    @Expose
    var site: String,

    @SerializedName("size")
    @Expose
    var size: Int,

    @SerializedName("name")
    @Expose
    var name: String
): Parcelable
