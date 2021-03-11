import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int result = subtract(num1, num2,num3);
        System.out.println(result);
    }

    private static int sumFirstAndSecond(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }

    private static  int subtract(int num1, int num2, int num3){
        int subtract = sumFirstAndSecond(num1, num2) - num3;
        return subtract;
    }
}
