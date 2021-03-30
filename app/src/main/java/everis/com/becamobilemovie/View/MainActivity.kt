package everis.com.becamobilemovie.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import everis.com.becamobilemovie.*
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.Model.ClickMovieItemListener
import everis.com.becamobilemovie.Model.MoviesAdapter
import everis.com.becamobilemovie.View.MovieDetailActivity.Companion.EXTRA_FILM
import everis.com.becamobilemovie.ViewModel.MoviesViewModel

class MainActivity : AppCompatActivity(), ClickMovieItemListener {

    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.RV_List)
    }
    private val Adapter = MoviesAdapter(this)
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesViewModel = ViewModelProvider.NewInstanceFactory().create(MoviesViewModel::class.java)
        moviesViewModel.init()

        initObserv()
        bindview()
    }
    fun initObserv(){
        moviesViewModel.moviesList.observe(this, { list ->
            UpdateList(list)
        })
    }



    fun bindview(){
        rvList.adapter = Adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }
    fun UpdateList(list: List<Movies>) {
        Adapter.UpdateAdapter(list)
    }

    override fun ClickItemMovie(Movie: Movies) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra(EXTRA_FILM, Movie)
        startActivity(intent)
    }
}