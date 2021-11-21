package es.programacionmultimedia

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val TAG = "[DEBUG] "

    override fun onStart() {
        Log.d(TAG, "on start")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "on resume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "on pause")
        super.onPause()
    }

    override fun onRestart() {
        Log.d(TAG, "on restart")
        super.onRestart()
    }

    override fun onStop() {
        Log.d(TAG, "on stop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "Actividad destruida")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.d(TAG, "on ConfigurationChanged")
        super.onConfigurationChanged(newConfig)
    }

}