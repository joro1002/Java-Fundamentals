import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            int number = Integer.parseInt(command);

            if (palindrome(number)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            command = scanner.nextLine();
        }
    }

    private static boolean palindrome(int number) {
        StringBuilder builder1 = new StringBuilder();
        builder1.append(number);

        StringBuilder builder = new StringBuilder();

        while (number > 0) {
            int num = number % 10;
            builder.append(num);
            number /= 10;
        }
        return builder.toString().equals(builder1.toString());

    }
}
