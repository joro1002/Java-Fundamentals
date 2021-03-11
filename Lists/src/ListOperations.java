import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")){
            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("Add")){
                int number = Integer.parseInt(tokens[1]);
                numbers.add(number);
            }else if(tokens[0].equals("Insert")){
                int number = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);
                if (index >= 0 && index <= numbers.size() - 1){
                    numbers.add(index, number);
                }else {
                    System.out.println("Invalid index");
                }
            }else if (tokens[0].equals("Remove")){
                int index = Integer.parseInt(tokens[1]);
                if (index >= 0 && index <= numbers.size() - 1){
                   numbers.remove(index);
                }else {
                    System.out.println("Invalid index");
                }
            }else if (tokens[0].equals("Shift") && tokens[1].equals("left")){
                int count = Integer.parseInt(tokens[2]);
                for (int i = 0; i < count; i++) {
                    numbers.add(numbers.get(0));
                    numbers.remove(0);
                }
            }else if (tokens[0].equals("Shift") && tokens[1].equals("right")){
                int count = Integer.parseInt(tokens[2]);
                for (int i = 0; i < count; i++) {
                   int last = numbers.get(numbers.size() - 1);
                   numbers.remove(numbers.size() - 1);
                   numbers.add(0, last);
                }
            }

            command = scanner.nextLine();
        }

        for (int number:
             numbers) {
            System.out.print(number + " ");
        }
    }
}
