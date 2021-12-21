package com.programacionmultimedia.data

import es.programacionmultimedia.domain.model.Film
import es.programacionmultimedia.domain.model.MessageType
import es.programacionmultimedia.domain.repository.LoggerRepository
import javax.inject.Inject


class HardCodedDataSource @Inject constructor(private val loggerRepository: LoggerRepository) {


    private val peaky = Film("Peaky Blinders","Action",
    "An after war film where a highly dangerous mafia tries to get control over different cties in UK",
    "Alex Roland", 5.0,"","")

    private val filmListOf = listOf(peaky)

    fun getFilm(posFilm: Int) : Film {

        if (filmListOf.isEmpty()) {
            loggerRepository.printLog("Film list is empty", MessageType.ERROR)
        }
        return filmListOf[posFilm]
    }

    fun getFilmList() = filmListOf

}