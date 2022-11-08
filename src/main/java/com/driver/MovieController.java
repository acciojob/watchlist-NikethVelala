package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody  Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("add movie done" , HttpStatus.OK);
    }

    @PostMapping("add-director")
    public  ResponseEntity<String > addDirector(@RequestBody Director director){
        movieService.addDirector(director);

        return new ResponseEntity<>("add director done" , HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovie(name);

        return new  ResponseEntity<>(movie , HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirector(name);
        return new ResponseEntity<>(director ,HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> m = movieService.getAllMovies();
        return new ResponseEntity<>(m ,HttpStatus.OK);
    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie ,
                                                       @RequestParam String director){
        movieService.addMovieAndDirector(movie , director);
        return  new ResponseEntity<>("add movie and director done" , HttpStatus.OK);

    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteMovieAndDirector(director);
        return new ResponseEntity<>("delete director and it's movie" , HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("delete all director and movie" , HttpStatus.OK);
    }
}