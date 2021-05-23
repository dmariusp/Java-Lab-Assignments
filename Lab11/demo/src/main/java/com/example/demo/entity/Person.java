package com.example.demo.entity;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Person {

    private int id;
    private String name;
    private List<Person> friendsList;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.friendsList = new LinkedList<>();
    }

    public void addFriend(Person friend) {
        this.friendsList.add(friend);
    }

}