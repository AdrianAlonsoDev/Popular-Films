package com.programacionmultimedia.data.implementation

import com.programacionmultimedia.data.server.ServerDataSource
import es.programacionmultimedia.domain.model.Film
import es.programacionmultimedia.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val serverDataSource: ServerDataSource
) : FilmRepository {

    override suspend fun getFilm(filmPos: Int, language: String): Film? {
        return runCatching {
            serverDataSource.getFilm(filmPos, language)
        }.getOrNull()

    }

    override suspend fun getFilmList(language: String): List<Film>? {
        TODO("Not yet implemented")
    }


}