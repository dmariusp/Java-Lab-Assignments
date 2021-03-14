package Compulsory;

import Compulsory.school.School;
import Compulsory.school.SchoolsComparator;
import Compulsory.student.ApplicationSorter;
import Compulsory.student.Student;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);

        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);

        List<Student> arrayOfStudents = new LinkedList<Student>(Arrays.asList(students));
        arrayOfStudents.sort(new ApplicationSorter());

        Set<School> schoolSetter = new TreeSet<School>(new SchoolsComparator());
        schoolSetter.add(schools[0]);
        schoolSetter.add(schools[1]);
        schoolSetter.add(schools[2]);

        for (School school : schoolSetter)
            System.out.println(school);

        for (Student student : arrayOfStudents)
            System.out.println(student);

        //create Student map
        Map<Student, LinkedList<School>> studentsPreferences = new HashMap<Student, LinkedList<School>>();
        studentsPreferences.put(students[0], new LinkedList<School>(Arrays.asList(schools[0], schools[1], schools[2])));
        studentsPreferences.put(students[1], new LinkedList<School>(Arrays.asList(schools[0], schools[1], schools[2])));
        studentsPreferences.put(students[2], new LinkedList<School>(Arrays.asList(schools[0], schools[1])));
        studentsPreferences.put(students[3], new LinkedList<School>(Arrays.asList(schools[1], schools[2])));

        System.out.println("Students map is: ");
        for (Map.Entry<Student, LinkedList<School>> entry : studentsPreferences.entrySet())
            System.out.println(entry);

        //create School map
        Map<School, LinkedList<Student>> schoolPreferences = new TreeMap<>();
        schoolPreferences.put(schools[0], new LinkedList<Student>(Arrays.asList(students[3], students[0], students[1], students[2])));
        schoolPreferences.put(schools[1], new LinkedList<Student>(Arrays.asList(students[0], students[1], students[2])));
        schoolPreferences.put(schools[2], new LinkedList<Student>(Arrays.asList(students[0], students[1], students[3])));

        System.out.println("Schools map is: ");
        for (Map.Entry<School, LinkedList<Student>> entry : schoolPreferences.entrySet())
            System.out.println(entry);
    }
}
