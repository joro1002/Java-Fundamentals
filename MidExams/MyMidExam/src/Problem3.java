import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("END")){
            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("Change")){
                int paintingNumber = Integer.parseInt(tokens[1]);
                int changedNumber = Integer.parseInt(tokens[2]);
                if (numbers.contains(paintingNumber)){
                    numbers.set(numbers.indexOf(paintingNumber), changedNumber);
                }
            }
            else if (tokens[0].equals("Hide")){
                int paintingNumber = Integer.parseInt(tokens[1]);
                if (numbers.contains(paintingNumber)){
                    numbers.remove(numbers.indexOf(paintingNumber));
                }
            }else if (tokens[0].equals("Switch")){
                int paintingNumber = Integer.parseInt(tokens[1]);
                int paintingNumber2 = Integer.parseInt(tokens[2]);
                if (numbers.contains(paintingNumber) && numbers.contains(paintingNumber2)){
                    int indexOne = numbers.indexOf(paintingNumber);
                    int indexTwo = numbers.indexOf(paintingNumber2);
                    numbers.set(indexOne, paintingNumber2);
                    numbers.set(indexTwo, paintingNumber);
                }
            }else if (tokens[0].equals("Insert")){
                int place = Integer.parseInt(tokens[1]);
                int paintingNumber = Integer.parseInt(tokens[2]);
                if (place >= 0 && place <= numbers.size() - 1){
                    numbers.add(place + 1, paintingNumber);
                }
            }else {
                Collections.reverse(numbers);
            }


            command = scanner.nextLine();
        }

        for (int number:
             numbers) {
            System.out.print(number + " ");
        }
    }
}
