package everis.com.becamobilemovie.View

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import everis.com.becamobilemovie.*
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.Domain.ClickMovieItemListener
import everis.com.becamobilemovie.Domain.MovieAdapter
import everis.com.becamobilemovie.View.MovieDetailActivity.Companion.EXTRA_FILM
import everis.com.becamobilemovie.ViewModel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ClickMovieItemListener {

    private val rvList: RecyclerView by lazy {
        findViewById(R.id.RV_List)
    }
    private val Adapter = MovieAdapter(this)
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesViewModel = ViewModelProvider.NewInstanceFactory().create(MoviesViewModel::class.java)
        moviesViewModel.init()

        loadingVisibility(true)
        initObserv()
        bindview()

        Image_Busca.setOnClickListener{
            loadingVisibility(true)
            filtroFilmes()
            val view = currentFocus
            val Keyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            Keyboard.hideSoftInputFromWindow(view?.windowToken, 0)
        }
    }
    fun initObserv(){
        moviesViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()){
                UpdateList(list)
                loadingVisibility(false)
            }
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
        intent.putExtra(EXTRA_FILM, Movie.id)
        startActivity(intent)
    }

    private fun loadingVisibility(loading: Boolean){
        ProgressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }

    private fun filtroFilmes(){
        val mutableListFilms = mutableListOf<Movies>()
        moviesViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()) {
                if (EdText_Busca.text.isNotEmpty()){
                    for (movie in list) {
                        if (movie.name.contains(EdText_Busca.text)) {
                            mutableListFilms.add(movie)
                        }
                    }
                    if(mutableListFilms.isNotEmpty()){
                        UpdateList(mutableListFilms)
                        loadingVisibility(false)
                    }else {
                        Toast.makeText(this,"Não encontrado nada correspondente", Toast.LENGTH_SHORT).show()
                        loadingVisibility(false)
                    }
                }else{
                    UpdateList(list)
                    loadingVisibility(false)
                }
            }
        })
    }
}