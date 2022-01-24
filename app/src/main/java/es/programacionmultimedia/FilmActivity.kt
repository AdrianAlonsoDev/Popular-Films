package es.programacionmultimedia

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.programacionmultimedia.components.DebugLog
import es.programacionmultimedia.databinding.ActivityFilmBinding
import es.programacionmultimedia.viewmodels.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint
class FilmActivity : AppCompatActivity() {

    @Inject
    lateinit var logger: DebugLog

    private var binding: ActivityFilmBinding? = null

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logger.log("Creating Activity and binding layout")

        binding = ActivityFilmBinding.inflate(layoutInflater)

        binding?.portada?.setImageResource(R.drawable.portadados)

        binding?.fondo?.setImageResource(R.drawable.fondo)

        binding?.cc?.text = resources.getString(R.string.CCButtonText)

        binding?.pg?.text = resources.getString(R.string.pgAge)

        binding?.tags?.text = resources.getString(R.string.tags)

        binding?.alquilarBoton?.text = resources.getString(R.string.rent)

        binding?.comprarBoton?.text = resources.getString(R.string.buy)

        setContentView(binding?.root)

        viewModel.loadFilm()

        viewModel.film.observe(this) {

            binding?.titulo?.text = it.title

            binding?.descripcionTexto?.text = it.description

            binding?.ratingBar?.rating = it.rating.toFloat() / 2

            binding?.portada?.let { it2 -> Glide.with(this).load(it.imageUrl).into(it2) }

            binding?.director?.text = it.director


        }

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