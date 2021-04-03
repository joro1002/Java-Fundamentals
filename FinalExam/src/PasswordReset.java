import javax.annotation.processing.SupportedSourceVersion;
import java.time.format.SignStyle;
import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("TakeOdd")) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    if (i % 2 == 1) {
                        builder.append(input.charAt(i));
                    }
                }
                System.out.println(builder);
                input = builder.toString();
            } else if (tokens[0].equals("Cut")) {
                int index = Integer.parseInt(tokens[1]);
                int length = Integer.parseInt(tokens[2]);

                String first = input.substring(0, index);
                String second = input.substring(index);
                String replace = second.substring(length);

                System.out.println(first + replace);
                input = first + replace;
            } else {
                String substring = tokens[1];
                String substitute = tokens[2];

                if (input.contains(substring)) {
                    String newText = input.replace(substring, substitute);
                    System.out.println(newText);
                    input = newText;
                } else {
                    System.out.println("Nothing to replace!");
                }
            }

            command = scanner.nextLine();
        }
        System.out.println("Your password is: " + input);
    }
}
