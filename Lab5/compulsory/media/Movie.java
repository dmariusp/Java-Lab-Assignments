package compulsory.media;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter

public class Movie extends Item {
    private String actors;
    private String year;

    public Movie(String id, String name, String location, String year, String actors) {
        super(id, name, location);
        this.actors = actors;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "actors=" + actors +
                ", year='" + year + '\'' +
                ", inherits from " + super.toString() +
                '}';
    }
}
