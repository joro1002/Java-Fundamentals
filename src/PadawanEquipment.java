import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceOfLightsabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobes = Double.parseDouble(scanner.nextLine());
        double priceOfBelts = Double.parseDouble(scanner.nextLine());

        double freeBelts = 0;
        for (int i = 1; i <= countOfStudents; i++) {
            if (i % 6 == 0) {
                freeBelts++;
            }
        }

        double belts = Math.ceil(countOfStudents + countOfStudents * 0.1);
        double price = priceOfLightsabers * (belts) + priceOfRobes * (countOfStudents) + priceOfBelts * (countOfStudents - freeBelts);

        if (price <= amountOfMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", price);
        } else if (price > amountOfMoney) {
            System.out.printf("Ivan Cho will need %.2flv more.", price - amountOfMoney);
        }
    }
}
