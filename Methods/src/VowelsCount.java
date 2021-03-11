import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int count = vowelsCount(text);
        System.out.println(count);
    }

    private static int vowelsCount(String text) {
        String[] arr = text.split("");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("a") || arr[i].contains("A")) {
                count++;
            }else if (arr[i].contains("e") || arr[i].contains("E")){
                count++;
            }else if (arr[i].contains("i") || arr[i].contains("I")){
                count++;
            }else if (arr[i].contains("o") || arr[i].contains("O")){
                count++;
            }else if (arr[i].contains("u") || arr[i].contains("U")){
                count++;
            }else if (arr[i].contains("y") || arr[i].contains("Y")){
                count++;
            }
        }
        return count;
    }
}
