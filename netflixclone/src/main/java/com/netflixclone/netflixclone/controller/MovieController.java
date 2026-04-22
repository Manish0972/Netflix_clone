package com.netflixclone.netflixclone.controller;

import com.netflixclone.netflixclone.entity.Movie;
import com.netflixclone.netflixclone.service.MovieService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import com.netflixclone.netflixclone.dto.MovieDto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@RestController                 // indicates that this class is a REST controller, which means it will handle HTTP requests and return responses in a RESTful manner
@RequestMapping("/api/movies")  // base URL for all movie-related endpoints
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) { // constructor injection
        this.movieService = movieService; // inject the MovieService dependency
    }

   @PostMapping // to create a new movie
    public Movie createMovie(@Valid @RequestBody MovieDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    @GetMapping // to get all movies
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")// to get a movie by ID
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/genre/{genre}") // to get movies by genre
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @PutMapping("/{id}") // to update a movie by ID
        public Movie updateMovie(
        @PathVariable Long id,
        @Valid @RequestBody MovieDto movieDto) {

    return movieService.updateMovie(id, movieDto); // call the service method to update the movie and return the updated movie
    }

    @DeleteMapping("/{id}") // to delete a movie by ID
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    

    @GetMapping("/paginated") // to get movies with pagination
    public Page<Movie> getMovies(
        @RequestParam int page, 
        @RequestParam int size) {

        return movieService.getMovies(page, size);
    }

    @GetMapping("/search") // to search movies by title keyword
        public ResponseEntity<List<Movie>> searchMovies(
        @RequestParam String keyword) {

            return ResponseEntity.ok(movieService.searchMovies(keyword)); //
        }
}