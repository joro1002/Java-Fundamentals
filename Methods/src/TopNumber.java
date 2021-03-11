import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            if (sumOfDigitsDivisibleBy8(i) && oneOddDigit(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean sumOfDigitsDivisibleBy8(int number) {
        int sum = 0;

        while (number > 0) {
            int num = number % 10;
            sum += num;
            number /= 10;
        }
        if (sum % 8 == 0) {
            return true;
        }
        return false;

    }

    public static boolean oneOddDigit(int number) {

        while (number > 0) {
            int num = number % 10;
            if (num % 2 == 1) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
