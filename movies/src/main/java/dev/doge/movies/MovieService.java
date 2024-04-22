package dev.doge.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    //autowired = instanitate class
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    //Optional mean could null when findById
    public Optional<Movie> getSingleMovie(String id){
        return movieRepository.findMovieByImdbId(id);
    }
}
