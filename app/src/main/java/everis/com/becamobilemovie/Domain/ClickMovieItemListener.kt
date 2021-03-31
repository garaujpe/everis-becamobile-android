package everis.com.becamobilemovie.Domain

import everis.com.becamobilemovie.DataClass.Movies

interface ClickMovieItemListener {
    fun ClickItemMovie(Movie: Movies)
}