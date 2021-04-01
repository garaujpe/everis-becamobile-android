package everis.com.becamobilemovie.Api

import everis.com.becamobilemovie.DataClass.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsApi {
    companion object{
        const val API_KEY = "a9db10997b829bfe25d6c577d6817f3b"
        const val LANGUAGE = "&language=pt-BR"
    }
    @GET("3/movie/{Id}?api_key=$API_KEY$LANGUAGE")
    fun getMovie(@Path("Id") Id:Int): Call<Movies>
}