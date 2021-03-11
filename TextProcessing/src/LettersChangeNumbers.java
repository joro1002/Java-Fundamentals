import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (String text : input) {
            char first = text.charAt(0);
            char last = text.charAt(text.length() - 1);

            double number = Double.parseDouble(text.substring(1, text.length() - 1));

            if (Character.isUpperCase(first)){
                number = number / (first - 'A' + 1);
            }else {
                number *= (first - 'a' + 1);
            }

            if (Character.isUpperCase(last)){
                number -= (last - 'A' + 1);
            }else {
                number += (last - 'a' + 1);
            }
            sum += number;
        }
        System.out.println(String.format("%.2f", sum));
    }
}
