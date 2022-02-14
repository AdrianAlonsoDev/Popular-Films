package es.programacionmultimedia

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import es.programacionmultimedia.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun OnCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}