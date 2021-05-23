package com.example.demo.databaseconn;

import java.sql.SQLException;

public class DbFriendship {
    public static void addFriendship(int personID, int friendID) throws SQLException {

        var conn = DbConn.getConnection();
        var statement = conn.prepareStatement("INSERT INTO FRIENDSHIPS VALUES (?,?,?)");

        statement.setInt(1, getLastIndexFriendships() + 1);
        statement.setInt(2, personID);
        statement.setInt(3, friendID);
        statement.executeQuery();
    }

    public static Integer getLastIndexFriendships() throws SQLException {

        var conn = DbConn.getConnection();
        var statement = conn.prepareStatement("SELECT max(ID) FROM FRIENDSHIPS");
        var result = statement.executeQuery();

        result.next();

        return result.getInt(1) + 1;
    }
}