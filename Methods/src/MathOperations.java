import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        int result = calculation(firstNumber, operation, secondNumber);

        System.out.print(result);
    }

    private static int calculation(int firstNumber, String operation, int secondNumber) {
        double sum = 0.0;

        switch (operation) {
            case "+":
                sum += firstNumber + secondNumber;
                break;
            case "-":
                sum += firstNumber - secondNumber;
                break;
            case "*":
                sum += firstNumber * secondNumber;
                break;
            case "/":
                sum += firstNumber / secondNumber;
                break;
        }
        return (int) sum;
    }
}
