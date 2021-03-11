import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfTheStudents = Integer.parseInt(scanner.nextLine());
        int countOfTheLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int attendance = 0;
        for (int i = 0; i < countOfTheStudents; i++) {
            int attendancesOfStudent = Integer.parseInt(scanner.nextLine());

            double total = (double) attendancesOfStudent / countOfTheLectures * (5 + additionalBonus);
            if (total > maxBonus){
                maxBonus = total;
                attendance = attendancesOfStudent;
            }

        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", attendance);
    }
}
