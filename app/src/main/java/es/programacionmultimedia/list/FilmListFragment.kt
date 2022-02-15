package es.programacionmultimedia.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import es.programacionmultimedia.FilmLauncher
import es.programacionmultimedia.R
import es.programacionmultimedia.databinding.ActivityFilmListBinding
import es.programacionmultimedia.debug.DebugLog
import javax.inject.Inject

@AndroidEntryPoint
class FilmListFragment : Fragment() {

    @Inject
    lateinit var adapter: FilmListAdapter

    @Inject
    lateinit var logger: DebugLog

    private lateinit var binding: ActivityFilmListBinding

    private val viewModel: FilmListViewModel by viewModels()

    private var filmLauncher: FilmLauncher? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        filmLauncher = context as? FilmLauncher
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ActivityFilmListBinding.inflate(layoutInflater)


        binding.root.adapter = adapter

        val isTablet = resources.getBoolean(R.bool.isTablet)

        if (isTablet) {
            binding.root.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        } else {
            binding.root.layoutManager = GridLayoutManager(context, 2)
        }



        viewModel.loadFilmList()

        viewModel.filmList.observe(this) {
            adapter.submitList(it)
        }

        adapter.callback = {
            logger.log("Click en película: $")
            filmLauncher?.openDetails(it.id)
        }
        return binding.root
    }


}