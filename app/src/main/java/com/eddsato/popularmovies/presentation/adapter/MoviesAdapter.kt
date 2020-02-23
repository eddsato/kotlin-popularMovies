package com.eddsato.popularmovies.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.eddsato.popularmovies.AppConstants
import com.eddsato.popularmovies.R
import com.eddsato.popularmovies.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movies_list_item.view.*

class MoviesAdapter(private val listener: OnMovieClick) :
    RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    private var movies: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        return MoviesHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movies_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        val item = movies.get(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onMovieClick(item, holder.itemView.iv_poster)
        }
    }

    fun swapMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    class MoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) = with(itemView) {
            Picasso.with(itemView.context)
                .load(AppConstants.POSTER_BASE_URL + movie.backdropPath)
                .into(iv_poster)
            tv_movie_title.text = movie.title
        }
    }

    interface OnMovieClick {
        fun onMovieClick(movie: Movie, imageView: ImageView)
    }
}
