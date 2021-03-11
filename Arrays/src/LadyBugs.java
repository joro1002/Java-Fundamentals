import javax.security.sasl.SaslClient;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize  = Integer.parseInt(scanner.nextLine());

        int[] field = new int[fieldSize];

        int[] ladybugs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int ladybug:
             ladybugs) {
            if (ladybug >= 0 && ladybug <= field.length - 1){
                field[ladybug] = 1;
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            int index = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int flyLength = Integer.parseInt(tokens[2]);

            if (index >= 0 && index <= field.length - 1 && field[index] == 1) {

                field[index] = 0;
                if (direction.equals("right")) {
                    index += flyLength;
                    while (index <= field.length - 1 && field[index] == 1) {
                        index += flyLength;
                    }

                    if (index <= field.length - 1) {
                        field[index] = 1;
                        //каца
                    }
                } else if (direction.equals("left")) {
                    index -= flyLength;
                    while (index >= 0 && field[index] == 1) {
                        index -= flyLength;
                    }
                    if (index >= 0) {
                        field[index] = 1;
                    }
                }
            }


            command = scanner.nextLine();
        }
        for (int result:field) {
            System.out.print(result + " ");
        }
    }
}
