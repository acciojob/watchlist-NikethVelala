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
        movieService.addM(movie);
        return new ResponseEntity<>("add movie done" , HttpStatus.OK);
    }

    @PostMapping("add-director")
    public  ResponseEntity<String > addDirector(@RequestBody Director director){
        movieService.addD(director);

        return new ResponseEntity<>("add director done" , HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.getM(name);

        return new  ResponseEntity<>(movie , HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.getD(name);
        return new ResponseEntity<>(director ,HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> m = movieService.getAllM();
        return new ResponseEntity<>(m ,HttpStatus.OK);
    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie ,
                                                       @RequestParam String director){
        movieService.addMoAndDi(movie , director);
        return  new ResponseEntity<>("add movie and director done" , HttpStatus.OK);

    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteMovAndDire(director);
        return new ResponseEntity<>("delete director and it's movie" , HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDi();
        return new ResponseEntity<>("delete all director and movie" , HttpStatus.OK);
    }
}