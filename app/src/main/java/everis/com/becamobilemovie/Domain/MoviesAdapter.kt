package everis.com.becamobilemovie.Domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.R
import kotlinx.android.synthetic.main.movies_item.view.*

class MovieAdapter(private var Listener: ClickMovieItemListener): RecyclerView.Adapter<MoviesViewHolder>(){

    private val movieList = arrayListOf<Movies>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_item, parent, false)
        return MoviesViewHolder(view, movieList, Listener)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
            Text_Name.text = movieList[position].name
            Text_Raiting.text = movieList[position].raiting.toString()
            Text_Lançamento.text = movieList[position].lançamento
            Picasso.get().load("https://image.tmdb.org/t/p/w342" + movieList[position].capa).into(IM_Movie)
        }
    }
    override fun getItemCount():Int = movieList.size

    fun UpdateAdapter(List: List<Movies>){
        this.movieList.clear()
        this.movieList.addAll(List)
        notifyDataSetChanged()
    }
}

class MoviesViewHolder(itemView: View, var List: List<Movies>, var Listener: ClickMovieItemListener): RecyclerView.ViewHolder(itemView){
    init {
        itemView.setOnClickListener{
            Listener.ClickItemMovie(List[adapterPosition])
        }
    }
}
