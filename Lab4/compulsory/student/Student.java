package Compulsory.student;

import lombok.Data;
import lombok.NonNull;

import java.util.Comparator;
import java.util.List;

public @Data
class Student implements Comparator<Student> {
    @NonNull
    private String name;

    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
