package com.programacionmultimedia.data.server.dto

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("known_for_department") val department: String,
    @SerializedName("original_name") val name: String
)
