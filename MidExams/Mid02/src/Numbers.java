import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> greaterThanAverage = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > average) {
                greaterThanAverage.add(numbers[i]);
            }
        }
        Collections.sort(greaterThanAverage);
        Collections.reverse(greaterThanAverage);

        if (greaterThanAverage.isEmpty()) {
            System.out.println("No");
        } else {
            int count = 0;
            for (int num :
                    greaterThanAverage) {
                System.out.print(num + " ");
                count++;
                if (count == 5) {
                    break;
                }
            }

        }
    }
}
