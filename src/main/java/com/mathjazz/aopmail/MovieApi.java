package com.mathjazz.aopmail;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieApi {

    public static boolean add;

    private List<Movie> movieList;

    public MovieApi() {
        this.movieList = new ArrayList<>();
        movieList.add(new Movie("Green Book", 2018, "USA"));
        movieList.add(new Movie("Bogowie", 2014, "Polska"));
        movieList.add(new Movie("Gladiator", 2000, "USA/Wielka Brytania"));
        movieList.add(new Movie("Leon zawodowiec", 1994, "Francja"));
    }


    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PostMapping
    @MovieAspectAnn
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        add = movieList.add(movie);
        if(add) {
            return new ResponseEntity(HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);


    }


}
