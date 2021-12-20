package com.programacionmultimedia.data.implementation

import com.programacionmultimedia.data.HardCodedDataSource
import es.programacionmultimedia.domain.model.Film
import es.programacionmultimedia.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(private val dataSource: HardCodedDataSource): FilmRepository {

    override fun getFilm() = dataSource.getFilm()

}