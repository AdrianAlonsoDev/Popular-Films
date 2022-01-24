package com.programacionmultimedia.data.server.dto

import com.google.gson.annotations.SerializedName

class FilmListDto(
    @SerializedName("results") val resultList: List<FilmDto>
)