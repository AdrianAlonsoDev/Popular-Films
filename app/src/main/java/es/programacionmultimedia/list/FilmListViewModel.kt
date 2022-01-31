package es.programacionmultimedia.list

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.programacionmultimedia.domain.usecase.GetFilmListUseCase
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val useCase: GetFilmListUseCase
) : ViewModel(), LifecycleObserver {

    private val filmListLiveData = MutableLiveData<List<FilmOverviewDataView>>()
    val filmList: LiveData<List<FilmOverviewDataView>> = filmListLiveData

    var job: Job? = null

    fun loadFilmList() {
        val language = Locale.getDefault().language

        job = CoroutineScope(Dispatchers.IO).launch {
            val loadedFilmList = useCase.execute(language)
            withContext(Dispatchers.Main) {
                loadedFilmList?.let {
                    filmListLiveData.value =
                        it.map { film -> FilmOverviewDataView(film.id, film.title, film.imageUrl) }
                }
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}