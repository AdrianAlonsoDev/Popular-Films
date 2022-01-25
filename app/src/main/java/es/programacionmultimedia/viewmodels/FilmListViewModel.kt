package es.programacionmultimedia.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.programacionmultimedia.domain.usecase.GetFilmUseCase
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val useCase: GetFilmUseCase
) : ViewModel(), LifecycleObserver {

    var job: Job? = null

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}