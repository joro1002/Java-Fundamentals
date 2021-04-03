import javax.print.DocFlavor;
import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Decode")) {
            String[] tokens = command.split("\\|");

            switch (tokens[0]) {
                case "Move":
                    int number = Integer.parseInt(tokens[1]);
                    String substring = input.substring(0, number);
                    input.replace(0, number, "");
                    input.append(substring);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];

                    input.insert(index, value);

                    break;
                case "ChangeAll":
                    String text = tokens[1];
                    String replacement = tokens[2];
                    input = new StringBuilder(input.toString().replace(text, replacement));
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + input);
    }
}
