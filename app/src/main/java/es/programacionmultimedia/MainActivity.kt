package es.programacionmultimedia

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: DebugLog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log.log("onCreate")
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        log.log("on start")
        super.onStart()
    }

    override fun onResume() {
        log.log("on resume")
        super.onResume()
    }

    override fun onPause() {
        log.log("on pause")
        super.onPause()
    }

    override fun onRestart() {
        log.log("on restart")
        super.onRestart()
    }

    override fun onStop() {
        log.log("on stop")
        super.onStop()
    }

    override fun onDestroy() {
        log.log("Actividad destruida")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        log.log("on ConfigurationChanged")
        super.onConfigurationChanged(newConfig)
    }

}