package com.programacionmultimedia.data

import com.programacionmultimedia.data.dto.FilmDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_RUL = "https://api.themoviedb.org/3/"
const val API_KEY = "b8b87da2c33d192d5ad7f84fca99de9b"


interface ApiManagement {

    @GET("movie/{id}")
    suspend fun  getFilm(@Path("id") filmdId: Int,
                         @Query("language") language: String,
                         @Query("api_key") apiKey: String = API_KEY): FilmDto


}