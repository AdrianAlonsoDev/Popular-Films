package es.programacionmultimedia.detail

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.programacionmultimedia.domain.usecase.GetFilmUseCase
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val useCase: GetFilmUseCase
) : ViewModel(), LifecycleObserver {

    private val filmLiveData = MutableLiveData<FilmDataView>()
    val film: LiveData<FilmDataView> = filmLiveData
    var job: Job? = null

    fun loadFilm(id: Int) {
        val language = Locale.getDefault().language

        job = CoroutineScope(Dispatchers.IO).launch {
            val loadedFilm = useCase.execute(id, language)
            withContext(Dispatchers.Main) {
                loadedFilm?.let {
                    filmLiveData.value = FilmDataView(
                        it.id,
                        it.title,
                        it.description,
                        it.imageUrl,
                        it.rating,
                        it.director,
                        it.trailerId
                    )
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}