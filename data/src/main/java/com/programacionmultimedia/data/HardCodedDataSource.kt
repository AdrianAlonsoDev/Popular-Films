package com.programacionmultimedia.data

import es.programacionmultimedia.domain.model.Film
import javax.inject.Inject


class HardCodedDataSource @Inject constructor() {

    private val peaky = Film("Peaky Blinders","Action",
    "An after war film where a highly dangerous mafia tries to get control over different cties in UK",
    "Alex Roland", 5.0,"","")

    val filmListOf = listOf(peaky)

    fun getFilm(posFilm: Int) : Film = filmListOf[posFilm]

    fun getFilmList() = filmListOf

}