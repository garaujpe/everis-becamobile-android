package everis.com.becamobilemovie.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import everis.com.becamobilemovie.DataClass.Movies

class MoviesViewModel: ViewModel() {

    val ListMovies = arrayListOf(
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


    private var _moviesList = MutableLiveData<List<Movies>>()
    val moviesList: LiveData<List<Movies>>
    get() = _moviesList


    fun init(){
        getAllMovies()
    }


    private fun getAllMovies(){
        _moviesList.value = ListMovies
    }

}