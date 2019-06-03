package com.example.project.services;

import com.example.project.entities.Movie;
import com.example.project.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie findMovie(Long id){
        if (movieRepository.existsById(id))
            return movieRepository.getOne(id);
        throw new NullPointerException("no data found at id " + id);
    }

    public Movie updateMovie(Long id, Movie movie){
        if(movieRepository.existsById(id)){
            movie.setId(id);
            return movieRepository.save(movie);
        } throw new NullPointerException("trying to update a non-existing data at id" + id);
    }

    public Boolean deleteUser(Long id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return true;
        }throw new NullPointerException("trying to delete a non-existing data at id" + id);
    }

}
