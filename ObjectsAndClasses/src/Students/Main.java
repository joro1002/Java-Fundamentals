package Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Students> studentsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            double grade = Double.parseDouble(tokens[2]);

            Students students = new Students(firstName, lastName, grade);
            studentsList.add(students);
        }
        studentsList = studentsList.stream().sorted(Comparator.comparing(Students::getGrade).reversed()).collect(Collectors.toList());

        for (Students student:
             studentsList) {
            System.out.println(student);
        }
    }
}
