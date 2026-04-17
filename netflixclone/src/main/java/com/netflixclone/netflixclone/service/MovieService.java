package com.netflixclone.netflixclone.service;

import com.netflixclone.netflixclone.dto.MovieDto;
import com.netflixclone.netflixclone.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie createMovie(MovieDto movieDto);

    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    List<Movie> getMoviesByGenre(String genre);
}