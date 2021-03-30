package everis.com.becamobilemovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import everis.com.becamobilemovie.MovieDetailActivity.Companion.EXTRA_FILM
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ClickMovieItemListener {
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.RV_List)
    }
    private val Adapter = MoviesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindview()
        UpdateList()
    }
    fun bindview(){
        rvList.adapter = Adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }
    fun UpdateList(){
        Adapter.UpdateAdapter(
            arrayListOf(
                Movies(
                    id = 0,
                    name = "Filme 1",
                    capa = "Imagem de Capa",
                    sinopse = "Este é um texto de exemplo",
                    raiting = 10.0,
                    lançamento = "20/01/2021"
                ),
                Movies(
                    id = 1,
                    name = "Filme 2",
                    capa = "Imagem de Capa",
                    sinopse = "Este é um texto de exemplo",
                    raiting = 5.0,
                    lançamento = "13/03/2021"
                )
            )
        )
    }

    override fun ClickItemMovie(Movie: Movies) {
        val intent = Intent(this,MovieDetailActivity::class.java)
        intent.putExtra(EXTRA_FILM, Movie)
        startActivity(intent)
    }
}