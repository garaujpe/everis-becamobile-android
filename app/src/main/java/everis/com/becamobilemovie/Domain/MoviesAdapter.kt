package everis.com.becamobilemovie.Domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.R
import kotlinx.android.synthetic.main.movies_item.view.*

class MoviesAdapter(var Listener: ClickMovieItemListener)
    : RecyclerView.Adapter<MoviesAdapter.moviesViewHolder>() {

    private val ListMovies: MutableList<Movies> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): moviesViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.movies_item,parent,false)
        return moviesViewHolder(View,ListMovies,Listener)
    }
    override fun onBindViewHolder(holder: moviesViewHolder, position: Int) {
        holder.itemView.apply {
            Text_Name.text = ListMovies[position].name
            Text_Lançamento.text = ListMovies[position].lançamento
            Text_Raiting.text = ListMovies[position].raiting.toString()
        }
    }
    override fun getItemCount(): Int = ListMovies.size

    fun UpdateAdapter(List: List<Movies>){
        this.ListMovies.clear()
        this.ListMovies.addAll(List)
        notifyDataSetChanged()
    }

    inner class moviesViewHolder(itemView: View, var List: List<Movies>, var Listener: ClickMovieItemListener)
        : RecyclerView.ViewHolder(itemView){
        private val TVName: TextView = itemView.findViewById(R.id.Text_Name)
        private val TVRaiting: TextView = itemView.findViewById(R.id.Text_Raiting)
        private val TVLançamento: TextView = itemView.findViewById(R.id.Text_Lançamento)
        private val IVMovie: ImageView = itemView.findViewById(R.id.IM_Movie)

        init {
            itemView.setOnClickListener{
                Listener.ClickItemMovie(List[adapterPosition])
            }
        }
    }

}