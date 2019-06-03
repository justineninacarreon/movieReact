package com.example.project.controllers;

import com.example.project.entities.Movie;
import com.example.project.exceptions.InvalidRequestBodyException;
import com.example.project.pojo.ApiResponse;
import com.example.project.services.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Function;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService moviesService){
        this.movieService = moviesService;
    }

    @ApiOperation("find all movies")
    @GetMapping
    public ResponseEntity findAllMovies(){
        return ResponseEntity.status(200).body(movieService.findAllMovies());
    }

    @ApiOperation("add movies")
    @PostMapping
    public ResponseEntity addMovie(@RequestBody @Valid  Movie movie, Errors errors){
        if (errors.hasErrors())
            throw new InvalidRequestBodyException( getValidationErrors.apply(errors) );
        return ResponseEntity.status(201)

                .contentType(MediaType.APPLICATION_JSON_UTF8)

                .body(movieService.addMovie(movie));
    }

    @ApiOperation("find movie by id")
    @GetMapping("/{id}")
    public ResponseEntity findMovie(@PathVariable Long id){
        return ResponseEntity.status(200).body(movieService.findMovie(id));
    }

    @ApiOperation("update movie by id")
    @PutMapping("/{id}")
    public ResponseEntity updateMovie(@PathVariable Long id, @RequestBody @Valid Movie movies, Errors errors){
        if (errors.hasErrors())
            throw new InvalidRequestBodyException( getValidationErrors.apply(errors) );
        return ResponseEntity.status(200).body(movieService.updateMovie(id, movies));
    }

    @ApiOperation("delete movie by id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable Long id){
        if (movieService.deleteUser(id))
            return ResponseEntity.status(200).body(ApiResponse.builder().code(200)
                    .status("OK").message("data at id "+id+" successfully deleted").build());
        return ResponseEntity.status(400).body(ApiResponse.builder().code(400).
                status("BAD REQUEST").message("something went wrong").build());
    }
    private Function<Errors,String> getValidationErrors = err ->
            err.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));

    }

