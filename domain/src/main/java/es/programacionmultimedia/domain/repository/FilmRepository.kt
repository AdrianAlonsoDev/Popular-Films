package es.programacionmultimedia.domain.repository

import es.programacionmultimedia.domain.model.Film

/*
 * Film Repository interface
 */
interface FilmRepository {
    /*
     * getFilm function which returns a Film object
     */
    suspend fun getFilm(filmPos: Int, language: String): Film?
}