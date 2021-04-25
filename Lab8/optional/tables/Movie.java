package optional.tables;

import lombok.Data;

@Data
public class Movie {
    int movieID, duration, score;
    String Title, releaseDate, director;

    @Override
    public String toString() {
        return "Movie{" +
                "movieID=" + movieID +
                ", duration=" + duration +
                ", score=" + score +
                ", Title='" + Title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}