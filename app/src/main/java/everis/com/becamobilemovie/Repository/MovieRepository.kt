package everis.com.becamobilemovie.Repository

import android.util.Log
import everis.com.becamobilemovie.Api.MovieRestApiTask
import everis.com.becamobilemovie.DataClass.Movies

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movies>()

    fun getAllMovies(): List<Movies>{
        val request = movieRestApiTask.retrofiApi().getAllMovies().execute()
        if(request.isSuccessful){
            request.body()?.let {
                movieList.addAll(it)
            }
        }else{
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return movieList
    }



}