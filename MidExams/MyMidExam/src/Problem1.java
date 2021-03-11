import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double journey = Double.parseDouble(scanner.nextLine());
        int numberOfMonths = Integer.parseInt(scanner.nextLine());

        double monthPrice = 0;
        for (int i = 1; i <= numberOfMonths; i++) {
            if (i % 2 == 1 && i != 1) {
                monthPrice -= monthPrice * 0.16;
            }
            if (i % 4 == 0 && i != 1){
                monthPrice+= monthPrice * 0.25;
            }
            monthPrice += journey * 0.25;
        }

        if (monthPrice >= journey){
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", monthPrice - journey);
        }else {
            System.out.printf("Sorry. You need %.2flv. more.", journey - monthPrice);
        }
    }
}
