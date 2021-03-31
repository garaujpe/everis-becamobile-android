package everis.com.becamobilemovie.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.Domain.ClickMovieItemListener
import everis.com.becamobilemovie.R
import everis.com.becamobilemovie.ViewModel.MoviesDetailsViewModel
import kotlinx.android.synthetic.main.activity_main.ProgressBar
import kotlinx.android.synthetic.main.activity_movie_detail.*

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
        Text_Title.text = movie.name
        Text_Overview.text = movie.sinopse
        Text_Date.text = movie.lançamento
        Text_Notas.text = movie.raiting.toString()
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.capa).into(Image_Capa)
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