package dev.doge.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    //Autowired so it connect to DB itself (without = null exception)
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    //Template (Dynamic Query) without Repository to talk to db

    public Review createReview(String reviewBody, String imdbId){
        //associate review with found movie (create new review on the db)
        Review review = reviewRepository.insert(new Review(reviewBody));

        /* update call, Movie on db with matching [imdbId]
           to update the array of [reviewIds] when new review exists
        */
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
