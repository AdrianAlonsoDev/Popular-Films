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

    suspend fun getFilm(filmId: Int, language: String): Film {
        val filmDto = api.getFilm(filmId, language)
        val creditsDto = api.getCredits(filmId)

        val director = creditsDto.cast.firstOrNull { it.department == "Directing" }?.name ?: "Placeholder"
        val image = getFullUrl(filmDto.imageUrl)

        val video = api.getVideos(filmId, language).results.filter {
            it.site == "YouTube"
        }.firstOrNull{it.type == "Trailer"}?.id


        return Film(
            filmDto.id,
            filmDto.title,
            "",
            filmDto.description,
            director,
            filmDto.rating,
            image,
            video
        )
    }

    suspend fun getFilmList(language: String): List<Film>? {
        try {
            return api.getPopularFilmList(language).resultList.map {

                val image = getFullUrl(it.imageUrl)

                Film(it.id, it.title, "", it.description, null, it.rating, image, null)
            }
        } catch (e: Exception) {
            e
        }
        return null
    }

    private fun getFullUrl(imageUrl: String) =
        imageUrl.let {
            "https://image.tmdb.org/t/p/w500$it"
        }

}