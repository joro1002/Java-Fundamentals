import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")){
            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("swap")){
                int index1 = Integer.parseInt(tokens[1]);
                int index2 = Integer.parseInt(tokens[2]);

                int temp = numbers[index1];
                numbers[index1] = numbers[index2];
                numbers[index2] = temp;
            }else if (tokens[0].equals("multiply")){
                int index1 = Integer.parseInt(tokens[1]);
                int index2 = Integer.parseInt(tokens[2]);

                int multiply = numbers[index1] * numbers[index2];
                numbers[index1] = multiply;
            }else if (tokens[0].equals("decrease")){
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
            }

            command = scanner.nextLine();
        }
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1){
                System.out.print(numbers[i]);
            }else {
                System.out.print(numbers[i] + ", ");
            }
        }
    }
}
