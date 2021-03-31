package everis.com.becamobilemovie.Data

import everis.com.becamobilemovie.DataClass.Movies

interface MovieDetailDataSource {
    fun getMovie(): Movies
}