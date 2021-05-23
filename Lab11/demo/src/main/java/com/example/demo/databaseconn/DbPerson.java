package com.example.demo.databaseconn;

import com.example.demo.entity.Person;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DbPerson {
    public static void addPerson(Person person) throws SQLException {
        var conn = DbConn.getConnection();
        var statement = conn.prepareStatement("INSERT INTO PERSONS VALUES (?,?)");
        statement.setInt(1, person.getId());
        statement.setString(2, person.getName());
        statement.executeQuery();
    }

    public static Integer getLastIndexPersons() throws SQLException {
        var conn = DbConn.getConnection();
        var statement = conn.prepareStatement("SELECT max(ID) FROM PERSONS");
        var result = statement.executeQuery();
        result.next();
        return result.getInt(1) + 1;
    }

    public static void setPersonNameByID(int id, String name) throws SQLException {
        var conn = DbConn.getConnection();
        var statement = conn.prepareStatement("UPDATE PERSONS SET NAME=? WHERE ID=?");
        statement.setString(1, name);
        statement.setInt(2, id);
        statement.executeQuery();
    }

    public static void deletePersonByID(int id) throws SQLException {
        var conn = DbConn.getConnection();
        var statement = conn.prepareStatement("DELETE FROM PERSONS WHERE ID=?");
        statement.setInt(1, id);
        statement.executeQuery();
    }

    public static List<Person> getPersonsList() throws SQLException {
        List<Person> personsList = new LinkedList<>();

        var conn = DbConn.getConnection();
        var statement = conn.prepareStatement("SELECT * FROM PERSONS");
        var result = statement.executeQuery();

        //add persons
        while (result.next()) {
            var person = new Person(result.getInt(1), result.getString(2));
            personsList.add(person);
        }

        statement = conn.prepareStatement("SELECT * FROM FRIENDSHIPS");
        result = statement.executeQuery();

        //add friends
        while (result.next()) {
            Person person = null;
            Person friend = null;
            for (var tempPerson : personsList) {
                if (tempPerson.getId() == result.getInt(2))
                    person = tempPerson;
                if (tempPerson.getId() == result.getInt(3))
                    friend = tempPerson;
            }
            if (person != null)
                person.addFriend(friend);
        }
        return personsList;
    }
}