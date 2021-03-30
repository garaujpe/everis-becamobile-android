package everis.com.becamobilemovie

import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(var Listener: ClickMovieItemListener)
    : RecyclerView.Adapter<MoviesAdapter.ContactAdapterViewHolder>() {

    private val ListMovies: MutableList<Movies> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.movies_item,parent,false)
        return ContactAdapterViewHolder(View,ListMovies,Listener)
    }
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(ListMovies[position])
    }
    override fun getItemCount(): Int = ListMovies.size

    fun UpdateAdapter(List: List<Movies>){
        this.ListMovies.clear()
        this.ListMovies.addAll(List)
        notifyDataSetChanged()
    }

    inner class ContactAdapterViewHolder(itemView: View, var List: List<Movies>, var Listener: ClickMovieItemListener)
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

        fun bind(Movie: Movies){
            TVName.text = Movie.name
            TVRaiting.text = Movie.raiting.toString()
            TVLançamento.text = Movie.lançamento


        }
    }

}