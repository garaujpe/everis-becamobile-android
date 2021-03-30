package everis.com.becamobilemovie.Api

import everis.com.becamobilemovie.DataClass.Movies
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    companion object{
        const val API_KEY = "a9db10997b829bfe25d6c577d6817f3b"
        const val ROTA = "3/trending/movie/week?api_key="
    }
    @GET(ROTA + API_KEY)
    fun getAllMovies(): Call<List<Movies>>
}