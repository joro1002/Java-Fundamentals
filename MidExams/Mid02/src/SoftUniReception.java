import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfStudentsOne = Integer.parseInt(scanner.nextLine());
        int countOfStudentsTwo = Integer.parseInt(scanner.nextLine());
        int countOfStudentsThree = Integer.parseInt(scanner.nextLine());
        int allStudents = Integer.parseInt(scanner.nextLine());

        int allStudentsPerHour = countOfStudentsOne + countOfStudentsTwo + countOfStudentsThree;

        int hours = 0;

        while (allStudents > 0){
            allStudents -= allStudentsPerHour;
            hours++;
            if (hours % 4 ==0 && hours != 0){
                hours++;
            }
        }
        System.out.printf("Time needed: %dh.",hours);
    }
}
