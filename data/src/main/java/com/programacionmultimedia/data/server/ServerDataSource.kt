package com.programacionmultimedia.data.server

import es.programacionmultimedia.domain.model.Film
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServerDataSource @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: ApiManagement = retrofit.create(ApiManagement::class.java)

    suspend fun getFilm(id: Int, language: String): Film {
        val filmDto = api.getFilm(id, language)
        val creditsDto = api.getCredits(id)

        val director = creditsDto.cast.firstOrNull { it.department == "Directoring" }?.name ?: ""
        val image = "https://image.tmdb.org/t/p/w500${filmDto.imageUrl}"

        return Film(filmDto.title, filmDto.imageUrl, director, filmDto.description, filmDto.rating)
    }
}