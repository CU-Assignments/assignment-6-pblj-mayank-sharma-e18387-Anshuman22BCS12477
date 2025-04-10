// File: EmployeeSort.java
import java.util.*;

public class EmployeeSort {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Anshuman", 20, 50000),
                new Employee("Anish", 25, 60000),
                new Employee("Ankit", 28, 55000)
        );

        System.out.println("Sort by Name:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        System.out.println("\nSort by Age:");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println);

        System.out.println("\nSort by Salary:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);
    }
}
