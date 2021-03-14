package Compulsory.school;

import Compulsory.student.Student;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public @Data
class School implements Comparable<School> {
    @NonNull
    private String name;
    private int capacity;

    public int compareTo(School s) {
        if (this.name == null)
            return 0;
        return this.name.compareTo(s.getName());
    }

}
