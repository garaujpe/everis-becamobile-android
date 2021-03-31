package everis.com.becamobilemovie.UseCase

import everis.com.becamobilemovie.Data.MovieDetailRepository
import everis.com.becamobilemovie.Data.MovieRepository

class MoviesListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMovieFromDataSource()
}
class MoviesDetailsUseCase(private val movieDetailRepository: MovieDetailRepository){

    operator fun invoke() = movieDetailRepository.getMovieDetailFromDataSource()
}