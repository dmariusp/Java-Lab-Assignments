package optional;

import optional.dao.GenreDAO;
import optional.dao.MovieDAO;
import optional.tables.Genre;
import optional.tables.Movie;

import java.sql.SQLException;

public class MainOptional {
    public static void main(String[] args)
            throws SQLException {

        Movie movie = new Movie();
        Genre genreAction = new Genre();

        movie.setMovieID(48);
        movie.setTitle("MovieTest");
        movie.setReleaseDate("11/11/2011");
        movie.setDuration(159);
        movie.setScore(10);

        genreAction.setGenreID(45);
        genreAction.setName("Drama");

        GenreDAO genreDAO = new GenreDAO();
        MovieDAO movieDAO = new MovieDAO();

        //movie Add
        movieDAO.add(movie);

        //movie Read by ID
        Movie movieReadTestID = movieDAO.getMoviebyID(1);
        System.out.println(movieReadTestID);


        //genre Add
        genreDAO.add(genreAction);

        //genre Read by ID
        Genre genreReadTestID = genreDAO.getGenrebyID(1);
        System.out.println(genreReadTestID);


    }
}
