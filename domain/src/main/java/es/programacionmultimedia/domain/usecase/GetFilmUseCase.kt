package es.programacionmultimedia.domain.usecase

import es.programacionmultimedia.domain.repository.FilmRepository
import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private val filmRepository: FilmRepository
) {
    suspend fun execute(posFilm: Int, language: String) = filmRepository.getFilm(posFilm, language)
}