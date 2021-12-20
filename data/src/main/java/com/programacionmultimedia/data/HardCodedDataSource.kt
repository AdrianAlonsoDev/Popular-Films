package com.programacionmultimedia.data

import es.programacionmultimedia.domain.model.Film
import javax.inject.Inject


class HardCodedDataSource @Inject constructor() {

    fun getFilm() = Film("Peaky Blinders","",0.00,"")

}