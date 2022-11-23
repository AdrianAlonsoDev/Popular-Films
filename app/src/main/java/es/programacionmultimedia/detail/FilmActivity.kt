package es.programacionmultimedia.detail

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.programacionmultimedia.R
import es.programacionmultimedia.databinding.ActivityFilmBinding
import es.programacionmultimedia.debug.DebugLog
import javax.inject.Inject

@AndroidEntryPoint
class FilmActivity : AppCompatActivity() {

    companion object {
        const val FILM_ID = "ID"
    }

    @Inject
    lateinit var logger: DebugLog

    private lateinit var binding: ActivityFilmBinding

    private val viewModel: FilmViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logger.log("Creating Activity and binding layout")

        binding = ActivityFilmBinding.inflate(layoutInflater)

        binding.poster.setImageResource(R.drawable.portadados)

        binding.posterGrande.setImageResource(R.drawable.fondo)

        binding.cc.text = resources.getString(R.string.CCButtonText)

        binding.pg.text = resources.getString(R.string.pgAge)

        binding.tags.text = resources.getString(R.string.tags)

        binding.trailerBoton.text = resources.getString(R.string.buy)

        setContentView(binding.root)

        val id = intent?.extras?.getInt(FILM_ID)?: 512195

        viewModel.loadFilm(id)

        viewModel.film.observe(this) {

            binding.titulo.text = it.title

            binding.descripcionTexto.text = it.description

            binding.ratingBar.rating = it.rating.toFloat() / 2

            binding.poster.let { it2 -> Glide.with(this).load(it.imageUrl).into(it2) }

            binding.director.text = it.director

            if(it.videoId == null) {
                binding.trailerBoton.visibility = View.GONE
            } else {
                binding.trailerBoton.visibility = View.VISIBLE
                binding.trailerBoton.setOnClickListener { _->
                    launchYoutube(it.videoId)
                }
            }


        }

    }

    fun launchYoutube(id: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=$id"))
        startActivity(intent)
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
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        logger.log("Activity configuration changed")
        super.onConfigurationChanged(newConfig)
    }

}