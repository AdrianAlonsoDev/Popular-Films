package es.programacionmultimedia.domain.usecase

import es.programacionmultimedia.domain.repository.FilmRepository
import javax.inject.Inject

class GetFilmListUseCase @Inject constructor(
    private val filmRepository: FilmRepository
) {
    suspend fun execute(language: String) = filmRepository.getFilmList(language)
}