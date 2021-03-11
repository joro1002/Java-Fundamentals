import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();


        int maxCount = 0;
        int maxNumber = 0;

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];

            int count = 0;
            for (int j = i + 1 ; j < numbers.length; j++) {

                if (current == numbers[j]) {
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                        maxNumber = numbers[j];
                    }
                }if (current != numbers[j]){
                    break;
                }
            }
        }

        for (int i = 0; i < maxCount + 1; i++) {
            System.out.print(maxNumber + " ");
        }
    }
}
