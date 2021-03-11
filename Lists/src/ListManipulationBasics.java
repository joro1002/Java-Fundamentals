import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    add(list, number);
                    break;
                case "Remove":
                    int number1 = Integer.parseInt(tokens[1]);
                    remove(list, number1);
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(tokens[1]);
                    removeAt(list, index);
                    break;
                case "Insert":
                    int num = Integer.parseInt(tokens[1]);
                    int index1 = Integer.parseInt(tokens[2]);
                    insert(list, num, index1);
                    break;

            }


            command = scanner.nextLine();
        }
        for (int num:
             list) {
            System.out.print(num + " ");
        }
    }

    public static void add(List<Integer> numbers, int number) {
        numbers.add(number);
    }

    public static void remove(List<Integer> numbers, int number){
        numbers.remove(Integer.valueOf(number));
    }

    public static void removeAt(List<Integer> numbers, int number){
        numbers.remove(number);
    }

    public static void insert(List<Integer> numbers, int number, int index){
        numbers.add(index, number);
    }
}
