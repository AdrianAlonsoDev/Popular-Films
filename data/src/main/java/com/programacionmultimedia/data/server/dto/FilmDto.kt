package com.programacionmultimedia.data.server.dto

import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val description: String,
    @SerializedName("vote_average") val rating: Double,
    @SerializedName("poster_path") val imageUrl: String
)
