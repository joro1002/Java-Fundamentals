import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("merge")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);

                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > input.size() - 1) {
                    endIndex = input.size() - 1;
                }

                for (int i = startIndex; i < endIndex; i++) {
                    String split = input.get(startIndex) + input.get(startIndex + 1);
                    input.set(startIndex, split);
                    input.remove(startIndex + 1);
                }
            } else if (tokens[0].equals("divide")) {
                int index = Integer.parseInt(tokens[1]);
                int part = Integer.parseInt(tokens[2]);

                List<String> dividedString = new ArrayList<>();

                String current = input.get(index);
                int substring = current.length() / part;
                int count = 0;
                String separatedElement = "";
                int countAdded = 0;

                for (int i = 0; i < current.length(); i++) {
                    char symbol = current.charAt(i);
                    separatedElement += symbol;
                    count++;

                    if (count == substring && countAdded + 1 < part) {
                        dividedString.add(separatedElement);
                        count = 0;
                        countAdded++;
                        separatedElement = "";
                    }
                }
                dividedString.add(separatedElement);
                input.remove(index);

                for (int i = dividedString.size() - 1; i >= 0; i--) {
                    input.add(index, dividedString.get(i));
                }
                break;
            }
            command = scanner.nextLine();
        }
        for (String result:
             input) {
            System.out.print(result + " ");
        }
    }
}

