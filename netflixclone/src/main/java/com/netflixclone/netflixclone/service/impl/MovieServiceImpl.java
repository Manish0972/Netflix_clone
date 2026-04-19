package com.netflixclone.netflixclone.service.impl;

import com.netflixclone.netflixclone.dto.MovieDto;
import com.netflixclone.netflixclone.entity.Movie;
import com.netflixclone.netflixclone.repository.MovieRepository;
import com.netflixclone.netflixclone.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie createMovie(MovieDto movieDto) {
    Movie movie = new Movie();

    movie.setTitle(movieDto.getTitle());
    movie.setDescription(movieDto.getDescription());
    movie.setGenre(movieDto.getGenre());
    movie.setReleaseYear(movieDto.getReleaseYear());
    movie.setThumbnailUrl(movieDto.getThumbnailUrl());
    movie.setVideoUrl(movieDto.getVideoUrl());

    return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
public Movie updateMovie(Long id, MovieDto movieDto) {

    Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movie not found"));

    movie.setTitle(movieDto.getTitle());
    movie.setDescription(movieDto.getDescription());
    movie.setGenre(movieDto.getGenre());
    movie.setReleaseYear(movieDto.getReleaseYear());
    movie.setThumbnailUrl(movieDto.getThumbnailUrl());
    movie.setVideoUrl(movieDto.getVideoUrl());

    return movieRepository.save(movie);
}

    @Override
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movieRepository.delete(movie);
    }
}