package optional.dao;

import optional.DatabaseConnection;
import optional.tables.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    static Connection con = DatabaseConnection.getConnection();

    public int add(Movie movie)
            throws SQLException {
        String query = "insert into movies(movieID, title," +
                "release_date, duration, score)" +
                "values (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, movie.getMovieID());
        ps.setString(2, movie.getTitle());
        ps.setString(3, movie.getReleaseDate());
        ps.setInt(4, movie.getDuration());
        ps.setInt(5, movie.getScore());
        return ps.executeUpdate();
    }

    public void delete(int id)
            throws SQLException {
        String query = "delete from movies where movieid=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public Movie getMoviebyID(int id)
            throws SQLException {
        String query = "select * from movies where movieid=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Movie movie = new Movie();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            movie.setMovieID(resultSet.getInt("movieid"));
            movie.setTitle(resultSet.getString("title"));
            movie.setReleaseDate(resultSet.getString("release_date"));
            movie.setDuration(resultSet.getInt("duration"));
            movie.setScore(resultSet.getInt("score"));
        }
        if (check) {
            return movie;
        } else
            return null;
    }

    public Movie getMoviebyName(String name)
            throws SQLException {
        String query = "select * from movies where title=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        Movie movie = new Movie();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            movie.setMovieID(resultSet.getInt("movieid"));
            movie.setTitle(resultSet.getString("title"));
            movie.setReleaseDate(resultSet.getString("release_date"));
            movie.setDuration(resultSet.getInt("duration"));
            movie.setScore(resultSet.getInt("score"));
        }
        if (check) {
            return movie;
        } else
            return null;
    }

    public List<Movie> getMovies()
            throws SQLException {
        String query = "select * from movies";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        List<Movie> ls = new ArrayList<>();

        while (resultSet.next()) {
            Movie movie = new Movie();
            movie.setMovieID(resultSet.getInt("movieid"));
            movie.setTitle(resultSet.getString("title"));
            movie.setReleaseDate(resultSet.getString("release_date"));
            movie.setDuration(resultSet.getInt("duration"));
            movie.setScore(resultSet.getInt("score"));
            ls.add(movie);
        }
        return ls;
    }
}