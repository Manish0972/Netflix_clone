package com.netflixclone.netflixclone.service;

import org.springframework.data.domain.Page;

import com.netflixclone.netflixclone.dto.MovieDto;
import com.netflixclone.netflixclone.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie createMovie(MovieDto movieDto);


    Page<Movie> getMovies(int page, int size);

    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    List<Movie> getMoviesByGenre(String genre);

    List<Movie> searchMovies(String keyword);

    Movie updateMovie(Long id, MovieDto movieDto);

    void deleteMovie(Long id);

}