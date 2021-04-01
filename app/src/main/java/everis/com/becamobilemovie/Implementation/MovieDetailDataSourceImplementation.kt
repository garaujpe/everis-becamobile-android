package everis.com.becamobilemovie.Implementation

import android.util.Log
import everis.com.becamobilemovie.Api.MovieRestApiTask
import everis.com.becamobilemovie.Data.MovieDetailDataSource
import everis.com.becamobilemovie.DataClass.Movies

class MovieDetailDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask): MovieDetailDataSource {

    companion object{
        const val TAG = "MovieDetailDataSource"
    }
    private lateinit var movieDetail: Movies
    private var id = 299536

    override fun getMovie(): Movies {
        val request = movieRestApiTask.retrofitDetailsApi().getMovie(id).execute()
        if(request.isSuccessful){
            request.body()?.let {
                movieDetail = it
            }
        }else{
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return movieDetail
    }
    fun setId(id: Int){
        this.id = id
    }
}