package Compulsory.school;

import java.util.Comparator;

public class SchoolsComparator implements Comparator<School> {
    public int compare(School s1, School s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
