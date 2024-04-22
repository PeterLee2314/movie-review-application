package dev.doge.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data //lombok get/set
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    //ObjectId is auto-generated
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseData;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference //store only id of reviews, views in seperate collections (manual reference relationship)
    private List<Review> reviewIds;
}
