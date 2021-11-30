package com.programacionmultimedia.data.implementation

import es.programacionmultimedia.domain.model.Film
import es.programacionmultimedia.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(): FilmRepository {

    override fun getFilm() = Film("Peaky Blinders","",0.00,"")

}