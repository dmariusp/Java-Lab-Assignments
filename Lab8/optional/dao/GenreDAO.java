package optional.dao;

import optional.DatabaseConnection;
import optional.tables.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    static Connection con = DatabaseConnection.getConnection();

    public int add(Genre genre)
            throws SQLException {
        String query = "insert into genres(genreid, name)" +
                "values (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, genre.getGenreID());
        ps.setString(2, genre.getName());
        return ps.executeUpdate();
    }

    public void delete(int id)
            throws SQLException {
        String query = "delete from Genres where genreid=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public Genre getGenrebyID(int id)
            throws SQLException {
        String query = "select * from Genres where genreID=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Genre genre = new Genre();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            genre.setGenreID(resultSet.getInt("genreid"));
            genre.setName(resultSet.getString("name"));
        }

        if (check) {
            return genre;
        } else
            return null;
    }

    public Genre getGenrebyName(String name)
            throws SQLException {
        String query = "select * from Genres where name=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        Genre genre = new Genre();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            genre.setGenreID(resultSet.getInt("genreid"));
            genre.setName(resultSet.getString("name"));
        }

        if (check) {
            return genre;
        } else
            return null;
    }

    public List<Genre> getGenres()
            throws SQLException {
        String query = "select * from genres";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        List<Genre> ls = new ArrayList<>();

        while (resultSet.next()) {
            Genre genre = new Genre();
            genre.setGenreID(resultSet.getInt("genreid"));
            genre.setName(resultSet.getString("name"));
            ls.add(genre);
        }
        return ls;
    }

}