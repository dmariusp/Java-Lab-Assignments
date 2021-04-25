package optional.dao;

import optional.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class ActorsDirectorsDAO {
        static Connection con = DatabaseConnection.getConnection();

        public void add(int movieID, String actorsList, String directorList)
                throws SQLException{
            String query = "insert into ActorsDirectors(movieID, actorList" +
                    ", directorList) values (?, ?, ?)";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, movieID);
            ps.setString(2, actorsList);
            ps.setString(3, directorList);
            ps.executeUpdate();
        }

        public void delete(int mainID)
                throws SQLException{
            String query = "delete from ActorsDirectors where mainID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, mainID);
            ps.executeUpdate();
        }

    }