// File: StudentFilter.java
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double percentage;

    public Student(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() { return name; }
    public double getPercentage() { return percentage; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', percentage=" + percentage + "}";
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Amit", 88),
                new Student("Riya", 72),
                new Student("John", 79),
                new Student("Sneha", 91),
                new Student("Kunal", 65)
        );

        List<String> filtered = students.stream()
                .filter(s -> s.getPercentage() > 75)
                .sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Students scoring above 75% (sorted):");
        filtered.forEach(System.out::println);
    }
}
