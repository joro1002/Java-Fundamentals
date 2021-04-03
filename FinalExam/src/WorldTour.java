import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] tokens = command.split(":");
            switch (tokens[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String text = tokens[2];
                    if (index >= 0 && index <= input.length() - 1) {
                        input.insert(index, text);
                    }
                    System.out.println(input);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && startIndex <= input.length() - 1
                            && endIndex >= 0 && endIndex <= input.length() - 1) {
                        input.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(input);
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    input = new StringBuilder(input.toString().replace(oldString, newString));
                    System.out.println(input);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + input);
    }
}
