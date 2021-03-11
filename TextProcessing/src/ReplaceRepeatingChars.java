import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = "";
        char symbol = input.charAt(0);
        result += symbol;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (symbol != current) {
                symbol = current;
                result += current;
            }
        }
        System.out.println(result);
    }
}
