import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            if (i == numbers.length - 1){
                System.out.print(current);
                break;
            }

            boolean isBigger = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if (current > numbers[j]) {
                  isBigger = true;
                }else {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger){
                System.out.print(current + " ");
            }
        }
    }
}
