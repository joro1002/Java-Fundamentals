import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        matrix(n);

    }

    public static void matrix(int n){
        for (int col = 1; col <= n; col++) {
            for (int row = 1; row <= n ; row++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
