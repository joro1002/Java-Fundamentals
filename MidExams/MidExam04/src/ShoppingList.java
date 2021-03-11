import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Urgent":
                    String itemUrgent = tokens[1];
                    if (!list.contains(itemUrgent)){
                        list.add(0, itemUrgent);
                    }
                    break;
                case "Unnecessary":
                    String itemUnnecessary = tokens[1];
                    if (list.contains(itemUnnecessary)){
                        list.remove(itemUnnecessary);
                    }
                    break;
                case "Correct":
                    String oldItem = tokens[1];
                    String newItem = tokens[2];

                    if (list.contains(oldItem)){
                        int indexOldItem = list.indexOf(oldItem);
                        list.set(indexOldItem, newItem);
                    }
                    break;
                case "Rearrange":
                    String itemRearrange = tokens[1];
                    if (list.contains(itemRearrange)){
                        list.remove(itemRearrange);
                        list.add(itemRearrange);
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1){
                System.out.print(list.get(i));
            }else {
                System.out.print(list.get(i) + ", ");
            }
        }
    }
}
