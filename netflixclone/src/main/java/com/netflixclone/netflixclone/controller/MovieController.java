package com.netflixclone.netflixclone.controller;

import com.netflixclone.netflixclone.entity.Movie;
import com.netflixclone.netflixclone.service.MovieService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import com.netflixclone.netflixclone.dto.MovieDto;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

   @PostMapping
    public Movie createMovie(@Valid @RequestBody MovieDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @PutMapping("/{id}")
        public Movie updateMovie(
        @PathVariable Long id,
        @Valid @RequestBody MovieDto movieDto) {

    return movieService.updateMovie(id, movieDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}