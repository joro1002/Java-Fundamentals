import java.util.Arrays;
import java.util.Scanner;

public class EvenOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int even = 0;
        int odd = 0;

        for (int number :
                numbers) {
            if (number % 2 == 0) {
                even += number;
            } else {
                odd += number;
            }
        }
        System.out.println(even - odd);
    }
}
