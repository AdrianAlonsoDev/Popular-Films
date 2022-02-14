package com.programacionmultimedia.data.implementation

import com.programacionmultimedia.data.database.DatabaseDataSource
import com.programacionmultimedia.data.server.ServerDataSource
import es.programacionmultimedia.domain.model.Film
import es.programacionmultimedia.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val serverDataSource: ServerDataSource,
    private val databaseDataSource: DatabaseDataSource
) : FilmRepository {

    override suspend fun getFilm(filmPos: Int, language: String): Film? {
        return runCatching {
            val filmFromServer = serverDataSource.getFilm(filmPos, language)
            databaseDataSource.updateFilmList(listOf(filmFromServer))
            filmFromServer
        }.getOrNull() ?: kotlin.run {
            databaseDataSource.getFilm(filmPos)
        }

    }

    override suspend fun getFilmList(language: String): List<Film> {
        return runCatching {
            val filmListFromServer = serverDataSource.getFilmList(language)
            databaseDataSource.clearFilmList()
            databaseDataSource.updateFilmList(filmListFromServer ?: emptyList())

            filmListFromServer
        }.getOrNull() ?: kotlin.run {
            databaseDataSource.getFilmList()
        }
    }


}