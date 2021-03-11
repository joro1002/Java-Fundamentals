import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        int sum = sumOfEvenAndOddDigits(Math.abs(input));
        System.out.print(sum);
    }

    private static int sumOfEvenAndOddDigits(int input) {
        int even = sumOfEvenDigits(input);
        int odd = sumOfOddDigits(input);
        return even * odd;
    }

    private static int sumOfEvenDigits(int input) {
        int sum = 0;

        while (input > 0) {
            int digit = input % 10;
            if (digit % 2 == 0) {
                sum += digit;
            }
            input = input / 10;
        }
        return sum;
    }

    private static int sumOfOddDigits(int input) {
        int sum = 0;

        while (input > 0) {
            int digit = input % 10;
            if (digit % 2 != 0) {
                sum += digit;
            }
            input = input / 10;
        }
        return sum;
    }
}
