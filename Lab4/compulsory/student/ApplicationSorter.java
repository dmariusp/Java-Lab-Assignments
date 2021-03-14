package Compulsory.student;

import Compulsory.student.Student;

import java.util.Comparator;

public class ApplicationSorter implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
