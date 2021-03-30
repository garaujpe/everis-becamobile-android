package everis.com.becamobilemovie

import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactRecyclerView: RecyclerView.Adapter<ContactRecyclerView.ContactAdapterViewHolder>() {

    private val ListMovies: MutableList<Movies> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.movies_item,parent,false)
        return ContactAdapterViewHolder(View)
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

    inner class ContactAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val TVName: TextView = itemView.findViewById(R.id.Text_Name)
        private val TVRaiting: TextView = itemView.findViewById(R.id.Text_Raiting)
        private val TVLançamento: TextView = itemView.findViewById(R.id.Text_Lançamento)
        private val IVMovie: ImageView = itemView.findViewById(R.id.IM_Movie)

        fun bind(Movie: Movies){
            TVName.text = Movie.name
            TVRaiting.text = Movie.raiting.toString()
            TVLançamento.text = Movie.lançamento


        }
    }

}