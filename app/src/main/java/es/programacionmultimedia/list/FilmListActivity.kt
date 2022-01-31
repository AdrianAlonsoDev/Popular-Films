package es.programacionmultimedia.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import es.programacionmultimedia.databinding.ActivityFilmListBinding
import javax.inject.Inject

@AndroidEntryPoint
class FilmListActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: FilmListAdapter

    private lateinit var binding: ActivityFilmListBinding

    private val viewModel: FilmListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilmListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.root.adapter = adapter


    }


}