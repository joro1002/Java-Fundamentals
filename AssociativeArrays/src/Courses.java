import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, List<String >> courses = new LinkedHashMap<>();

        while (!command.equals("end")){
            String[] tokens = command.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            if (!courses.containsKey(courseName)){
                courses.put(courseName, new ArrayList<>());
                courses.get(courseName).add(studentName);
            }else {
                courses.get(courseName).add(studentName);
            }
            command = scanner.nextLine();
        }

        courses.entrySet()
                .stream()
                .sorted((f,s) -> s.getValue().size() - f.getValue().size())
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted((f,s) -> f.compareTo(s))
                            .forEach(s -> System.out.println("-- " + s));
                });

    }
}
