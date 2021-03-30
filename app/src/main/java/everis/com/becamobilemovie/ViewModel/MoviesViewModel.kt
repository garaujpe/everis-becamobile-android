package everis.com.becamobilemovie.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import everis.com.becamobilemovie.Api.MovieRestApiTask
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.Repository.MovieRepository
import kotlin.Exception

class MoviesViewModel: ViewModel() {
    companion object{
        const val TAG = "MoviesViewModel"
    }
    val movieRestApiTask = MovieRestApiTask()
    val movieRepository = MovieRepository(movieRestApiTask)

    private var _moviesList = MutableLiveData<List<Movies>>()
    val moviesList: LiveData<List<Movies>>
    get() = _moviesList

    fun init(){
        getAllMovies()
    }
    private fun getAllMovies(){
        Thread{
            try {
                _moviesList.postValue(movieRepository.getAllMovies())
            }catch (exception: Exception){
                Log.d(TAG,exception.message.toString())
            }
        }
    }

}