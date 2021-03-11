import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int waterTank = 255;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int quantity = Integer.parseInt(scanner.nextLine());

            sum += quantity;
            if (sum > waterTank){
                System.out.println("Insufficient capacity!");
                sum -= quantity;
            }
        }
        System.out.println(sum);
    }
}
