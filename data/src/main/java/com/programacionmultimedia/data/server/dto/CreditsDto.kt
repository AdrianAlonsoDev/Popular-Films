package com.programacionmultimedia.data.server.dto

import com.google.gson.annotations.SerializedName

data class CreditsDto(
    @SerializedName("cast") val cast: List<CastDto>
)
