import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n  = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if ((i + 1) % 2 != 0){
                firstArray[i] = line[0];
                secondArray[i] = line[1];
            }else {
                firstArray[i] = line[1];
                secondArray[i] = line[0];
            }
        }
        for (int first:
             firstArray) {
            System.out.printf(first + " ");
        }
        System.out.println();
        for (int second:
             secondArray) {
            System.out.printf(second + " ");
        }
        
    }
}
