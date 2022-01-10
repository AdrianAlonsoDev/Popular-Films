package es.programacionmultimedia

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logger.log("Creating Activity")

        setContentView(R.layout.activity_main)

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
        logger.log("Activity was destroyed")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        logger.log("Activity configuration changed")
        super.onConfigurationChanged(newConfig)
    }

}