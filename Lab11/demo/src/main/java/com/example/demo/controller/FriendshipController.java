package com.example.demo.controller;

import com.example.demo.databaseconn.DbFriendship;
import com.example.demo.databaseconn.DbPerson;
import com.example.demo.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/friendships")
public class FriendshipController {
    static List<Person> personList = PersonController.personsList;


    @GetMapping
    public static ResponseEntity<String> getFriends(@RequestParam int id) {
        Person person = null;
        for (var tempPersons : personList) {
            if (person == null && tempPersons.getId() == id) {
                person = tempPersons;
            }
        }
        if (person != null) {
            return new ResponseEntity<>("The user '" + person.getName() + "' has these friends:" + person.getFriendsList(), HttpStatus.OK);
        } else
            return new ResponseEntity<>("There is no user with the id: '" + id + "'.", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public static ResponseEntity<String> addFriendship(@RequestParam int personID, @RequestParam int friendID) {
        if (personID <= personList.size() && friendID <= personList.size()) {
            try {
                personList.get(personID - 1).getFriendsList().add(personList.get(friendID - 1));
                DbFriendship.addFriendship(personID, friendID);
                return new ResponseEntity<>("Added friendship between ID:" + personID + " and ID:" + friendID, HttpStatus.OK);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return new ResponseEntity<>("Failed to add friendship. One of the names is incorrectly written in the request", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mostKConnected")
    public static ResponseEntity<String> getKMostConnected(@RequestParam int k) {
        if (k > personList.size())
            return new ResponseEntity<>("", HttpStatus.INSUFFICIENT_STORAGE);
        personList.sort(Comparator.comparingInt(o -> o.getFriendsList().size()));
        var mostConnectedPersonsList = new ArrayList<>(personList.subList(0, k));
        return new ResponseEntity<>(mostConnectedPersonsList.toString(), HttpStatus.OK);
    }

    @GetMapping("/leastKConnected")
    public static ResponseEntity<String> getKLeastConnected(@RequestParam int k) {
        if (k > personList.size())
            return new ResponseEntity<>("", HttpStatus.INSUFFICIENT_STORAGE);
        personList.sort((o1, o2) -> o2.getFriendsList().size() - o1.getFriendsList().size());
        var mostConnectedPersonsList = new ArrayList<>(personList.subList(0, k));
        return new ResponseEntity<>(mostConnectedPersonsList.toString(), HttpStatus.OK);
    }
}