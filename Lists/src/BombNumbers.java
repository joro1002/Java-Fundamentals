import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String[] tokens = scanner.nextLine().split("\\s+");
        int specialNumber = Integer.parseInt(tokens[0]);
        int power = Integer.parseInt(tokens[1]);

        while (numbers.contains(specialNumber)) {
            int indexSpecialNumber = numbers.indexOf(specialNumber);
            int left = Math.max(indexSpecialNumber - power, 0);
            int right = Math.min(indexSpecialNumber + power, numbers.size() - 1);

            for (int i = left; i <= right; i++) {
                numbers.set(i, 0);
            }
        }

        int sum = 0;
        for (int num :
                numbers) {
            sum += num;
        }
        System.out.println(sum);
    }
}
