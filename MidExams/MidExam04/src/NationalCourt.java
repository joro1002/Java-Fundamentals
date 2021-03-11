import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeopleOne = Integer.parseInt(scanner.nextLine());
        int countPeopleTwo = Integer.parseInt(scanner.nextLine());
        int countPeopleThree = Integer.parseInt(scanner.nextLine());
        int allPeople = Integer.parseInt(scanner.nextLine());

        int allPeoplePerHour = countPeopleOne + countPeopleTwo + countPeopleThree;
        int hours = 0;



        while (allPeople > 0) {
            allPeople -= allPeoplePerHour;
            hours++;
            if (hours % 4 ==0 && hours != 0) {
                hours++;
            }
        }

        System.out.printf("Time needed: %dh.", hours);
    }
}
