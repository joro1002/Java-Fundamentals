import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());
        double factorialFirst = factorial(num1);
        double factorialSecond = factorial(num2);
        double result = factorialFirst / factorialSecond;
        System.out.printf("%.2f", result);
    }

    public static double factorial(double number) {

        double factorial = 1;

        for (int i = 0; i < number; i++) {
            factorial += factorial * i;
        }
        return factorial;
    }
}
