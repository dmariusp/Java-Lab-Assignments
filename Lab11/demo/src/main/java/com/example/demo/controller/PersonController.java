package com.example.demo.controller;

import com.example.demo.databaseconn.DbPerson;
import com.example.demo.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonController {
    static List<Person> personsList;

    static {
        try {
            personsList = DbPerson.getPersonsList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @GetMapping()
    public static List<Person> getPersonsList() {
        return personsList;
    }

    @GetMapping("/{id}")
    public static ResponseEntity<String> getPersonById(@PathVariable("id") int id) {
        for (var person : personsList)
            if (person.getId() == id)
                return new ResponseEntity<>(person.toString(), HttpStatus.FOUND);
        return new ResponseEntity<>("Couldn't find the person with id " + id + ".", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public static ResponseEntity<String> addPerson(@RequestParam String name) {
        try {
            var person = new Person(DbPerson.getLastIndexPersons(), name);
            DbPerson.addPerson(person);
            personsList.add(person);
            return new ResponseEntity<>("Added person '" + name + "'.", HttpStatus.CREATED);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return new ResponseEntity<>("Failed to add person '" + name + "'.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public static ResponseEntity<String> setPersonName(@PathVariable("id") int id, @RequestParam String newName) {
        Person person = null;

        for (var tempPerson : personsList)
            if (tempPerson.getId() == id) {
                person = tempPerson;
                break;
            }

        if (person != null) {
            try {
                DbPerson.setPersonNameByID(id, newName);
                person.setName(newName);
                return new ResponseEntity<>("Set the name for id " + id + " to '" + newName + "'.", HttpStatus.FOUND);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return new ResponseEntity<>("Couldn't find the id " + id + ".", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public static ResponseEntity<String> deletePerson(@RequestParam int id) {
        for (var person : personsList)
            if (person.getId() == id) {
                try {
                    DbPerson.deletePersonByID(id);
                    personsList.remove(person);
                    return new ResponseEntity<>("Removed the person '" + person + "'.", HttpStatus.OK);
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        return new ResponseEntity<>("There is no person with the id '" + id + "'.", HttpStatus.NOT_FOUND);
    }
}