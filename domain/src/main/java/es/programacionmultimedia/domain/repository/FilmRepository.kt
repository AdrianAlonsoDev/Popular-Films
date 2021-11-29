package es.programacionmultimedia.domain.repository

import es.programacionmultimedia.domain.entity.Film

interface FilmRepository {
    fun getFilm() : Film
}