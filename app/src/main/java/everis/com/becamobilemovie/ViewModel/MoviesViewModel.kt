package everis.com.becamobilemovie.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import everis.com.becamobilemovie.Api.MovieRestApiTask
import everis.com.becamobilemovie.Data.MovieRepository
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.Implementation.MovieDataSourceImplementation
import everis.com.becamobilemovie.UseCase.MoviesListUseCase
import kotlin.Exception

class MoviesViewModel: ViewModel() {
    companion object{
        const val TAG = "MoviesViewModel"
    }
    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val moviesListUseCase = MoviesListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movies>>()
    val moviesList: LiveData<List<Movies>>
    get() = _moviesList

    fun init(){
        getAllMovies()
    }
    private fun getAllMovies(){
        Thread{
            try {
                _moviesList.postValue(moviesListUseCase.invoke())
            }catch (exception: Exception){
                Log.d(TAG,exception.message.toString())
            }
        }.start()
    }
}