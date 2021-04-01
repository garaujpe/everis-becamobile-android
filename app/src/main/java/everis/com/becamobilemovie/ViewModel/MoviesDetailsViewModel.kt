package everis.com.becamobilemovie.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import everis.com.becamobilemovie.Api.MovieRestApiTask
import everis.com.becamobilemovie.Data.MovieDetailRepository
import everis.com.becamobilemovie.DataClass.Movies
import everis.com.becamobilemovie.Implementation.MovieDetailDataSourceImplementation
import everis.com.becamobilemovie.UseCase.MoviesDetailsUseCase

class MoviesDetailsViewModel: ViewModel() {
    companion object{
        const val TAG = "MoviesDetailsViewModel"
    }

    private var _movie = MutableLiveData<Movies>()
    val movie: LiveData<Movies>
        get() = _movie

    fun init(id:Int){
        val movieRestApiTask = MovieRestApiTask()
        val movieDataSource = MovieDetailDataSourceImplementation(movieRestApiTask,id)
        val movieRepository = MovieDetailRepository(movieDataSource)
        val moviesDetailsUseCase = MoviesDetailsUseCase(movieRepository)
        getMovies(moviesDetailsUseCase)
    }
    private fun getMovies(moviesDetailsUseCase: MoviesDetailsUseCase){
        Thread{
            try {
                _movie.postValue(moviesDetailsUseCase.invoke())
            }catch (exception: Exception){
                Log.d(TAG,exception.message.toString())
            }
        }.start()
    }
}