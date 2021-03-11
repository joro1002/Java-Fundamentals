import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;

        switch (day) {
            case "Friday":
                if (typeOfGroup.equals("Students")) {
                    price += 8.45;
                } else if (typeOfGroup.equals("Business")) {
                    price += 10.9;
                } else {
                    price += 15;
                }
                break;
            case "Saturday":
                if (typeOfGroup.equals("Students")) {
                    price += 9.8;
                } else if (typeOfGroup.equals("Business")) {
                    price += 15.6;
                } else {
                    price += 20;
                }

                break;
            case "Sunday":
                if (typeOfGroup.equals("Students")) {
                    price += 10.46;
                } else if (typeOfGroup.equals("Business")) {
                    price += 16;
                } else {
                    price += 22.5;
                }
                break;
        }
        if (typeOfGroup.equals("Students")) {
            if (people >= 30) {
                price -= price * 0.15;
            }
        } else if (typeOfGroup.equals("Business")) {
            if (people >= 100) {
                people -= 10;
            }
        } else {
            if (people >= 10 && people <= 20) {
                price -= price * 0.05;
            }
        }

        System.out.printf("Total price: %.2f", people * price);

    }
}
