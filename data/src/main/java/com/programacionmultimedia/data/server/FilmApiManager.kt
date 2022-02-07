package com.programacionmultimedia.data.server

import com.programacionmultimedia.data.server.dto.CreditsDto
import com.programacionmultimedia.data.server.dto.FilmDto
import com.programacionmultimedia.data.server.dto.FilmListDto
import com.programacionmultimedia.data.server.dto.VideoResultDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "b8b87da2c33d192d5ad7f84fca99de9b"


interface ApiManagement {

    @GET("movie/{id}")
    suspend fun getFilm(
        @Path("id") filmId: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String = API_KEY
    ): FilmDto

    @GET("movie/popular")
    suspend fun getPopularFilmList(
        @Query("language") language: String,
        @Query("api_key") apiKey: String = API_KEY
    ): FilmListDto

    @GET("movie/{id}/videos")
    suspend fun getVideos(
        @Path("id") filmId: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String = API_KEY
    ): VideoResultDto

    @GET("movie/{id}/credits")
    suspend fun getCredits(
        @Path("id") filmId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): CreditsDto
}