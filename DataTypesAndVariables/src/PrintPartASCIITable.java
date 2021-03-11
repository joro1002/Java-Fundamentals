import java.util.Scanner;

public class PrintPartASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        String result = " ";
        for (int i = start; i <= end ; i++) {
            result += (char)i;
            result += " ";
        }
        System.out.println(result);
    }
}
