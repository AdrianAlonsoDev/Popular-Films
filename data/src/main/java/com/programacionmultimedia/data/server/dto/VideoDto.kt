package com.programacionmultimedia.data.server.dto

import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("type") val type: String,
    @SerializedName("key") val id: String,
    @SerializedName("site") val site: String)
