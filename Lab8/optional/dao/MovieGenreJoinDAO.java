package optional.dao;

import optional.DatabaseConnection;
import optional.tables.Movie;
import optional.tables.MoviesGenres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieGenreJoinDAO {
    static Connection con = DatabaseConnection.getConnection();

    public static int add(MoviesGenres moviesGenres) throws SQLException{
        String query = "insert into moviesgenres(mainid, movieID, genreID)" +
                "values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, moviesGenres.getJoinID());
        ps.setInt(2, moviesGenres.getMovieID());
        ps.setInt(3, moviesGenres.getGenreID());
        return ps.executeUpdate();
    }

    public void delete(int id)
            throws SQLException {
        String query = "delete from moviesgenres where mainid=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public MoviesGenres getMoviesGenresbyID(int id)
            throws SQLException {
        String query = "select * from moviesgenres where mainID=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        MoviesGenres moviesGenres = new MoviesGenres();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            moviesGenres.setJoinID(resultSet.getInt("mainID"));
            moviesGenres.setMovieID((resultSet.getInt("movieID")));
            moviesGenres.setGenreID(resultSet.getInt("genreID"));
        }
        if (check) {
            return moviesGenres;
        } else
            return null;
    }
    public List<MoviesGenres> getMoviesGenres()
            throws SQLException {
        String query="select * from moviesgenres";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        List<MoviesGenres> ls = new ArrayList<>();

        while(resultSet.next()){
            MoviesGenres moviesGenres = new MoviesGenres();
            moviesGenres.setJoinID(resultSet.getInt("mainID"));
            moviesGenres.setMovieID(resultSet.getInt("movieID"));
            moviesGenres.setGenreID(resultSet.getInt("genreID"));
            ls.add(moviesGenres);
        }
        return ls;
    }
}
