import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputMoney = scanner.nextLine();
        double coins = 0;

        while (!inputMoney.equals("Start")) {
            double currentMoney = Double.parseDouble(inputMoney);
            if (currentMoney == 0.1 || currentMoney == 0.2 || currentMoney == 0.5 || currentMoney == 1 || currentMoney == 2) {
                coins += currentMoney;
            } else {
                System.out.printf("Cannot accept %.02f%n", Double.parseDouble(inputMoney));
            }

            inputMoney = scanner.nextLine();
        }
        String input = scanner.nextLine();


        while (!input.equals("End")) {
            String product = input;
            if (product.equals("Nuts")) {

                if (coins < 2.0) {
                    System.out.println("Sorry, not enough money");
                } else {
                    System.out.println("Purchased Nuts");
                    coins -= 2.0;
                }
            } else if (product.equals("Water")) {


                if (coins < 0.7) {
                    System.out.println("Sorry, not enough money");
                } else {
                    System.out.println("Purchased Water");
                    coins -= 0.7;
                }
            } else if (product.equals("Crisps")) {


                if (coins < 1.5) {
                    System.out.println("Sorry, not enough money");
                } else {
                    System.out.println("Purchased Crisps");
                    coins -= 1.5;
                }
            } else if (product.equals("Soda")) {


                if (coins < 0.8) {
                    System.out.println("Sorry, not enough money");
                } else {
                    System.out.println("Purchased Soda");
                    coins -= 0.8;
                }
            } else if (product.equals("Coke")) {


                if (coins < 1.0) {
                    System.out.println("Sorry, not enough money");
                } else {
                    System.out.println("Purchased Coke");
                    coins -= 1.0;
                }
            } else {
                System.out.println("Invalid product");
            }

            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", coins);

    }
}
