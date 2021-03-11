import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {
            String[] tokens = command.split(" - ");

            switch (tokens[0]) {
                case "Collect":
                    if (!items.contains(tokens[1])) {
                        items.add(tokens[1]);
                    }
                    break;

                case "Drop":
                    if (items.contains(tokens[1])) {
                        items.remove(tokens[1]);
                    }
                    break;

                case "Combine Items":
                    String[] combineItems = tokens[1].split(":");
                    String oldItem = combineItems[0];
                    String newItem = combineItems[1];

                    if (items.contains(oldItem)) {
                        int index = items.indexOf(oldItem);
                        items.add(index + 1, newItem);
                    }
                    break;

                case "Renew":
                    if (items.contains(tokens[1])) {
                        items.remove(tokens[1]);
                        items.add(tokens[1]);
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        for (int i = 0; i < items.size(); i++) {
            if (i == items.size() - 1){
                System.out.print(items.get(i));
            }else {
                System.out.print(items.get(i) + ", ");
            }
        }
    }
}
