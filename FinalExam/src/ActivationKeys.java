import javax.print.DocFlavor;
import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String command = scanner.nextLine();
        StringBuilder builder = new StringBuilder();

        while (!command.equals("Generate")) {
            String[] tokens = command.split(">>>");

            switch (tokens[0]) {
                case "Contains":
                    String text = tokens[1];
                    if (input.contains(text)) {
                        System.out.printf("%s contains %s%n", input, text);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);

                    if (startIndex >= 0 && startIndex <= input.length() - 1 &&
                            endIndex >= 0 && endIndex <= input.length() - 1) {
                        String upper;
                        String startText = input.substring(0, startIndex);
                        String endText = input.substring(endIndex);
                        if (upperOrLower.equals("Upper")) {
                            upper = input.substring(startIndex, endIndex ).toUpperCase();

                        } else {
                            upper = input.substring(startIndex, endIndex).toLowerCase();

                        }
                        builder.append(startText + upper + endText);
                        System.out.println(builder.toString());
                        input = builder.toString();
                        builder.setLength(0);
                    }
                    break;
                case "Slice":
                    int startIndexSlice = Integer.parseInt(tokens[1]);
                    int endIndexSlice = Integer.parseInt(tokens[2]);

                    if (startIndexSlice >= 0 && startIndexSlice <= input.length() - 1 &&
                            endIndexSlice >= 0 && endIndexSlice <= input.length() - 1) {
                        String startText = input.substring(0, startIndexSlice);
                        String endText = input.substring(endIndexSlice);
                        builder.append(startText + endText);
                        System.out.println(builder.toString());
                        input  = builder.toString();
                        builder.setLength(0);

                    }
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + input);
    }
}
