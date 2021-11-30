package es.programacionmultimedia.domain.repository

import es.programacionmultimedia.domain.model.Film

interface FilmRepository {
    fun getFilm() : Film
}