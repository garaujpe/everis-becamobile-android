package everis.com.becamobilemovie

import android.graphics.Movie
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactRecyclerView: RecyclerView.Adapter<ContactRecyclerView.ContactAdapterViewHolder>() {

    private val ListMovies: MutableList<Movies> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        TODO("Not yet implemented")
    }
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(ListMovies[position])
    }
    override fun getItemCount(): Int = ListMovies.size

    inner class ContactAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(Movie: Movies){

        }
    }

}