package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }
    public Director getDirector(String name){
        return movieRepository.getDirector(name);
    }
    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovie();
    }
    public void addMovieAndDirector(String movie ,String director){
        movieRepository.addMovieAndDirector(movie , director);
    }
    public void deleteMovieAndDirector(String director){
        movieRepository.deleteDirectorByName(director);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }

}