import javax.security.sasl.SaslClient;
import java.sql.SQLOutput;
import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Reveal")) {
            String[] tokens = command.split(":\\|:");

            switch (tokens[0]) {
                case "InsertSpace":
                    StringBuilder builder = new StringBuilder();
                    int index = Integer.parseInt(tokens[1]);
                    builder.append(input);
                    builder.insert(index, " ");
                    System.out.println(builder);
                    input = builder.toString();
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    if (input.contains(substring)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        StringBuilder reverseBuilder = new StringBuilder();
                        int startIndex = input.indexOf(substring.charAt(0));
                        String start = input.substring(0, startIndex);
                        String end = input.substring(startIndex + substring.length());
                        reverseBuilder.append(substring);
                        reverseBuilder.reverse();

                        stringBuilder.append(start).append(end).append(reverseBuilder.toString());
                        System.out.println(stringBuilder.toString());
                        input = stringBuilder.toString();
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringChange = tokens[1];
                    String replacement = tokens[2];

                    String newText = input.replaceAll(substringChange, replacement);
                    System.out.println(newText);
                    input = newText;
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + input);
    }
}
