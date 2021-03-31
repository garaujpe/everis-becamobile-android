package everis.com.becamobilemovie.Data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMovieFromDataSource() = movieDataSource.getAllMovies()
}
class MovieDetailRepository(private val movieDetailDataSource: MovieDetailDataSource){
    fun getMovieDetailFromDataSource() = movieDetailDataSource.getMovie()
}