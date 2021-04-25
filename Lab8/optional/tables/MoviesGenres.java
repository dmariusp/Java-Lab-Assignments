package optional.tables;

import lombok.Data;

@Data
public class MoviesGenres {
    int movieID, genreID, joinID;

    public MoviesGenres(int movieID, int genreID, int joinID) {
        this.movieID = movieID;
        this.genreID = genreID;
        this.joinID = joinID;
    }

    public MoviesGenres() {

    }
}


