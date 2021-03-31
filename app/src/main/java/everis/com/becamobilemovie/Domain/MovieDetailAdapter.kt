package everis.com.becamobilemovie.Domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.R
import kotlinx.android.synthetic.main.activity_movie_detail.view.*
import kotlinx.android.synthetic.main.movies_item.view.*

class MovieDetailAdapter(private var Listener: ClickMovieItemListener): RecyclerView.Adapter<MoviesDetailViewHolder>() {

   private lateinit var movie:Movies

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_movie_detail, parent, false)
        return MoviesDetailViewHolder(view, movie, Listener)
    }

    override fun onBindViewHolder(holder: MoviesDetailViewHolder, position: Int) {
        holder.itemView.apply {
            Text_Name.text = movie.name
            Text_Overview.text = movie.sinopse
            Text_Date.text = movie.lançamento
            Text_Notas.text = movie.raiting.toString()
            Picasso.get().load(movie.capa).into(Image_Capa)
        }
    }

    override fun getItemCount(): Int = 1

    fun UpdateAdapter(movieRecebido: Movies){
        this.movie = movieRecebido
        notifyDataSetChanged()
    }
}
class MoviesDetailViewHolder(itemView: View, var Movie: Movies, var Listener: ClickMovieItemListener): RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            Listener.ClickItemMovie(Movie)
        }
    }
}