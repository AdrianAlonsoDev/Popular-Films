package es.programacionmultimedia.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.programacionmultimedia.databinding.FilmListItemBinding
import javax.inject.Inject

open class FilmViewHolder(val binding: FilmListItemBinding) : RecyclerView.ViewHolder(binding.root)

typealias OnMessageClick = (FilmOverviewDataView) -> Unit

class FilmListAdapter @Inject constructor() :
    ListAdapter<FilmOverviewDataView, FilmViewHolder>(diffUtil) {


    companion object {

        private val diffUtil = object : DiffUtil.ItemCallback<FilmOverviewDataView>() {
            override fun areItemsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            ) =
                oldItem.id == newItem.id


            override fun areContentsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            ) =
                oldItem == newItem


        }
    }

    var callback: OnMessageClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder =
        object : FilmViewHolder(
            FilmListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) {}


    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        holder.binding.tituloPeliculaRC.text = film.title
        Glide.with(holder.binding.posterImageRC).load(film.imageUrl)
            .into(holder.binding.posterImageRC)
        holder.binding.root.setOnClickListener {
            callback?.invoke(film)
        }
    }
}