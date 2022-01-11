package es.programacionmultimedia.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.programacionmultimedia.domain.model.Film
import es.programacionmultimedia.domain.usecase.GetFilmUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetFilmUseCase
):
    ViewModel(), LifecycleObserver {

        private val filmLiveData = MutableLiveData<FilmDataView>()
        val film: LiveData<FilmDataView> = filmLiveData

        fun loadFilm() {
            val loadedFilm = useCase.execute(0)
            filmLiveData.value = FilmDataView(loadedFilm.title, loadedFilm.description)
        }

}