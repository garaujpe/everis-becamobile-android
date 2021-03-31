package everis.com.becamobilemovie.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.Domain.ClickMovieItemListener
import everis.com.becamobilemovie.Domain.MovieAdapter
import everis.com.becamobilemovie.Domain.MovieDetailAdapter
import everis.com.becamobilemovie.R
import everis.com.becamobilemovie.ViewModel.MoviesDetailsViewModel
import everis.com.becamobilemovie.ViewModel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.ProgressBar
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_detail.view.*
import kotlinx.android.synthetic.main.movies_item.*
import kotlinx.android.synthetic.main.movies_item.view.*

class MovieDetailActivity : AppCompatActivity(), ClickMovieItemListener {


    private var idMovies:Int = 0
    private lateinit var moviesDetailsViewModel: MoviesDetailsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        moviesDetailsViewModel = ViewModelProvider.NewInstanceFactory().create(MoviesDetailsViewModel::class.java)
        moviesDetailsViewModel.init()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadingVisibility(true)
        getExtra()
        initObserve()
    }

    private fun initObserve(){
        moviesDetailsViewModel.movie.observe(this, { movie ->
            UpdateMovie(movie)
            loadingVisibility(false)})
    }

    private fun UpdateMovie(movie: Movies) {
        Text_Name.text = movie.name
        Text_Overview.text = movie.sinopse
        Text_Date.text = movie.lançamento
        Text_Notas.text = movie.raiting.toString()
        Picasso.get().load(movie.capa).into(Image_Capa)
    }

    private fun getExtra(){
      idMovies = intent.getIntExtra(EXTRA_FILM,0)
    }

    companion object{
        const val EXTRA_FILM: String = "EXTRA_FILM"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun loadingVisibility(loading: Boolean){
        ProgressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }

    override fun ClickItemMovie(Movie: Movies) {
        TODO("Not yet implemented")
    }
}