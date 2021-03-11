import java.math.BigDecimal;
import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int target = 0;
        double half = power / 2.0;

        while (power >= distance) {
            power -= distance;
            target++;

            if (power == half && exhaustionFactor != 0) {
                power /= exhaustionFactor;
            }
        }
        System.out.println(power);
        System.out.println(target);
    }
}
