import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class FilterSortStudentsStream {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Aryan", 80),
            new Student("Riya", 70),
            new Student("Karan", 90),
            new Student("Neha", 60),
            new Student("Tanya", 85)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
