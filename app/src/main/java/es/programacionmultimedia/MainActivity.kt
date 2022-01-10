package es.programacionmultimedia

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.programacionmultimedia.databinding.ActivityMainBinding
import es.programacionmultimedia.domain.usecase.GetFilmListUseCase
import es.programacionmultimedia.domain.usecase.GetFilmUseCase
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var logger: DebugLog

    @Inject
    lateinit var filmUseCase: GetFilmUseCase

    @Inject
    lateinit var filmListUseCase: GetFilmListUseCase

    private var binding: ActivityMainBinding? = null

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logger.log("Creating Activity and binding layout")

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding?.portada?.setImageResource(R.drawable.portadados)

        binding?.fondo?.setImageResource(R.drawable.fondo)

        binding?.titulo?.text = resources.getString(R.string.titulo)

        binding?.descripcionTexto?.text = resources.getString(R.string.descripcion)

        binding?.cc?.text = resources.getString(R.string.CCButtonText)

        binding?.pg?.text = resources.getString(R.string.pgAge)

        binding?.tags?.text = resources.getString(R.string.tags)

        binding?.alquilarBoton?.text = resources.getString(R.string.rent)

        binding?.comprarBoton?.text = resources.getString(R.string.buy)

        setContentView(binding?.root)

        val film = filmUseCase.execute(0)
        logger.log(film.title)

        val filmListed = filmListUseCase.execute()
        logger.log(filmListed.joinToString(","))


    }

    override fun onStart() {
        logger.log("Activity has started")
        super.onStart()
    }

    override fun onResume() {
        logger.log("Activity was resumed")
        super.onResume()
    }

    override fun onPause() {
        logger.log("Activity is now paused")
        super.onPause()
    }

    override fun onRestart() {
        logger.log("Restarting Activity")
        super.onRestart()
    }

    override fun onStop() {
        logger.log("Activity has been stoped")
        super.onStop()
    }

    override fun onDestroy() {
        logger.log("Activity was destroyed and Layout binding unlinked")

        binding = null

        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        logger.log("Activity configuration changed")
        super.onConfigurationChanged(newConfig)
    }

}