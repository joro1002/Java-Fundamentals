import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        while (true) {
            if (first.get(0) > second.get(0)) {
                first.add(first.get(0));
                first.add(second.get(0));
            } else if (second.get(0) > first.get(0)) {
                second.add(second.get(0));
                second.add(first.get(0));
            }
            first.remove(first.get(0));
            second.remove(second.get(0));

            if (first.size() == 0) {
                int sumSecond = 0;
                for (int two :
                        second) {
                    sumSecond += two;
                }
                System.out.printf("Second player wins! Sum: %d", sumSecond);
                break;
            }

            if (second.size() == 0){
                int sumFirst = 0;

                for (int one:
                     first) {
                    sumFirst += one;
                }
                System.out.printf("First player wins! Sum: %d", sumFirst);
                break;
            }
        }
    }
}
