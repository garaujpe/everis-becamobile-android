package everis.com.becamobilemovie.Data

import everis.com.becamobilemovie.DataClass.Movies

interface MovieDataSource {
    fun getAllMovies(): List<Movies>
}