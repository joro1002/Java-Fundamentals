import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int number1 = number;
        int sum = 0;

        while (number>0){
            int factoriel = 1;
            int num = number %10;
            number /= 10;

            for (int i = 2; i <= num; i++) {
                factoriel *= i;
            }
            sum += factoriel;
        }
        if (sum ==number1){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
