import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("course start")) {
            String[] tokens = command.split(":");

            String lessonTittle = tokens[1];

            switch (tokens[0]) {
                case "Add":
                    if (!schedule.contains(lessonTittle)) {
                        schedule.add(lessonTittle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index <= schedule.size() - 1) {
                        if (!schedule.contains(lessonTittle)) {
                            schedule.add(index, lessonTittle);
                        }
                    }
                    break;
                case "Remove":
                    if (schedule.contains(lessonTittle)) {
                        schedule.remove(lessonTittle);
                    }
                    int indexLesson = schedule.indexOf(lessonTittle);
                    if (schedule.get(indexLesson+ 1).equals(lessonTittle + "-Exercise")){
                        schedule.remove(indexLesson + 1);
                    }
                    break;
                case "Swap":
                    String lessonTittle2 = tokens[2];
                   String exerciseOne = lessonTittle + "-Exercise";
                   String exerciseTwo = lessonTittle2 + "-Exercise";
                    if (schedule.contains(lessonTittle) && schedule.contains(lessonTittle2)) {
                        int indexOne = schedule.indexOf(lessonTittle);
                        int indexTwo = schedule.indexOf(lessonTittle2);
                        schedule.set(indexOne, lessonTittle2);
                        schedule.set(indexTwo, lessonTittle);

                        if (schedule.get(indexOne + 1).equals(exerciseOne)){
                            schedule.remove(indexOne + 1);
                            schedule.add(indexTwo + 1, exerciseOne);
                        }
                        if (indexTwo != schedule.size() -1 && schedule.get(indexTwo + 1).equals(exerciseTwo)){
                            schedule.remove(indexTwo + 1);
                            schedule.add(indexOne + 1, exerciseTwo);
                        }
                    }
                    break;
                case "Exercise":
                    String exercise1 = lessonTittle + "-Exercise";
                    if (!schedule.contains(lessonTittle)) {
                        schedule.add(lessonTittle);
                        schedule.add(exercise1);
                    }else if (schedule.contains(lessonTittle) && !schedule.contains(exercise1)){
                        int indexTittle = schedule.indexOf(lessonTittle);
                        schedule.add(indexTittle + 1, exercise1);
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        int count = 1;
        for (String result:
             schedule) {
            System.out.printf("%d.%s%n",count, result);
            count++;
        }
    }
}
