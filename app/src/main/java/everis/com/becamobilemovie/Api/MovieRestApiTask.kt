package everis.com.becamobilemovie.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRestApiTask {
    companion object{
        const val BASE_URL = "https://api.themoviedb.org/"
    }
    private fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun retrofiApi(): MovieApi = movieProvider().create(MovieApi::class.java)
}