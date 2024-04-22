package dev.doge.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//<Type,Id>
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //Return Movie, use ObjectId for find
    //MongoDB support extract column with same name (imdbId) from Movie class
    Optional<Movie> findMovieByImdbId(String imdbId);
}
