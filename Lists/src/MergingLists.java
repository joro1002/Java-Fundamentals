import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int min = Math.min(first.size(), second.size());

        for (int i = 0; i < min; i++) {
            System.out.print(first.get(i) + " " + second.get(i) + " ");
        }
        for (int i = min; i < first.size(); i++) {
            System.out.print(first.get(i) + " ");
        }
        for (int i = min; i <  second.size(); i++) {
            System.out.print(second.get(i) + " ");
        }
    }
}
