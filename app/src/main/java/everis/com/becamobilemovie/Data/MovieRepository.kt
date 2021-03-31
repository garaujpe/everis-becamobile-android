package everis.com.becamobilemovie.Data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMovieFromDataSource() = movieDataSource.getAllMovies()
}