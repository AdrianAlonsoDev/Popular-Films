package es.programacionmultimedia.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import es.programacionmultimedia.databinding.ActivityFilmListBinding
import es.programacionmultimedia.viewmodels.FilmListViewModel

@AndroidEntryPoint
class FilmListActivity : AppCompatActivity() {

    private var binding: ActivityFilmListBinding? = null

    private val viewModel: FilmListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilmListBinding.inflate(layoutInflater)

        setContentView(binding?.root)

    }


}