import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            int currentNumber = list.get(i);
            if (currentNumber < 0){
                list.remove(Integer.valueOf(currentNumber));
                i = -1;
            }
        }
        Collections.reverse(list);

        if (list.isEmpty()){
            System.out.println("empty");
        }
        for (int number:
             list) {
            System.out.print(number + " ");
        }
    }
}
