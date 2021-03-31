package everis.com.becamobilemovie.Api

import everis.com.becamobilemovie.DataClass.Movies
import retrofit2.Call
import retrofit2.http.GET

interface MovieDetailsApi {
    companion object{
        const val API_KEY = "a9db10997b829bfe25d6c577d6817f3b"
        const val ROTA1 = "3/movie/"
        const val ID = "791373"
        const val ROTA2 = "?api_key="
        const val LANGUAGE = "&language=pt-BR"
    }
    @GET(ROTA1 + ID + ROTA2 + API_KEY + LANGUAGE)
    fun getMovie(): Call<Movies>
}