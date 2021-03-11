import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");
            int element = Integer.parseInt(tokens[1]);
            if (tokens[0].equals("Delete")) {
                numbers.removeAll(Arrays.asList(element));
            } else if (tokens[0].equals("Insert")) {
                int index = Integer.parseInt(tokens[2]);
                numbers.add(index, element);
            }

            command = scanner.nextLine();
        }

        for (int num :
                numbers) {
            System.out.print(num + " ");
        }
    }
}
