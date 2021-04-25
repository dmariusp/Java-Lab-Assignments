package optional;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import compulsory.dao.GenreDAO;
import optional.dao.ActorsDirectorsDAO;
import optional.dao.MovieDAO;
import optional.dao.MovieGenreJoinDAO;
import optional.tables.Genre;
import optional.tables.Movie;
import optional.tables.MoviesGenres;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class ProcessCSV {

    static int idGlobal = 0;
    static MovieDAO movieDAO = new MovieDAO();
    static GenreDAO genreDAO = new GenreDAO();
    private MovieGenreJoinDAO movieGenreJoinDAO = new MovieGenreJoinDAO();
    static ActorsDirectorsDAO actorsDirectorsDAO = new ActorsDirectorsDAO();

    static Movie movie = new Movie();
    static Genre genre = new Genre();

    public static void CSVProcess(String filePath) {

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            int index = 0;
            String[] lineInArray = reader.readNext();

            while ((lineInArray = reader.readNext()) != null) {
                var movieName = lineInArray[1];
                var date_published = lineInArray[4];
                var genreName = lineInArray[5];
                var duration = Integer.parseInt(lineInArray[6]);
                var avg_vote = Integer.parseInt(lineInArray[14]);
                var actors = lineInArray[12];
                var directors = lineInArray[9];

                idGlobal++;

                movie.setMovieID(idGlobal);
                movie.setReleaseDate(date_published);
                movie.setTitle(movieName);
                movie.setDuration(duration);
                movie.setScore(avg_vote);

                genre.setGenreID(idGlobal);
                genre.setName(genreName);

                actorsDirectorsDAO.add(idGlobal, actors, directors);

                var genreSplit = genreName.split(",");
                for (var aux : genreSplit) {
                    aux = aux.replaceAll("\\s+", "");
                    var genreID = genreDAO.getGenrebyName(aux).getGenreID();
                    MovieGenreJoinDAO.add(new MoviesGenres(idGlobal, genreID, index));
                }


            }


        } catch (IOException | CsvValidationException | SQLException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}