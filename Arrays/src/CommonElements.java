import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array1 = scanner.nextLine().split(" ");
        String[] array2 = scanner.nextLine().split(" ");

        for (int i = 0; i < array2.length; i++) {
            String current = array2[i];

            for (int j = 0; j < array1.length; j++) {
                if (current.equals(array1[j])){
                    System.out.printf(array1[j] + " ");
                }
            }
        }
    }
}
