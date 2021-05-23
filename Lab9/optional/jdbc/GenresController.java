package optional.jdbc;

import compulsory.entityClasses.Genres;
import compulsory.repoClasses.GenresRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenresController extends GenresRepo {
    private Connection connection;

    public GenresController(Connection conn) throws SQLException {
        System.out.println("Controller created!");
        connection = conn;
    }

    @Override
    public void create(Genres genres) {
        try {
            String sql = "INSERT INTO genres(id, name) VALUES(?, ?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, genres.getId());
            pstm.setString(2, genres.getName());

            int code = pstm.executeUpdate();
            if (code != 0) {
                System.out.println("Inserted successfully!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

