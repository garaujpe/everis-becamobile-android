package everis.com.becamobilemovie.Implementation

import android.util.Log
import everis.com.becamobilemovie.Api.MovieRestApiTask
import everis.com.becamobilemovie.Data.MovieDataSource
import everis.com.becamobilemovie.DataClass.Movies

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask): MovieDataSource {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movies>()


    override fun getAllMovies(): List<Movies> {
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