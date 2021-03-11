import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int sum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                if (current + numbers[j] == sum){
                    System.out.print(current + " " + numbers[j]);
                    System.out.println();
                }
            }
        }
    }
}
