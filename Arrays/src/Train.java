import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] wagons = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            wagons[i] = Integer.parseInt(scanner.nextLine());
            sum += wagons[i];
        }
        for (int wagon:
             wagons) {
            System.out.printf(wagon + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
