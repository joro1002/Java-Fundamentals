import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char char1 = scanner.nextLine().charAt(0);
        char char2 = scanner.nextLine().charAt(0);

        charactersInRange(char1, char2);

    }

    public static void charactersInRange(char char1, char char2){

        int start = Math.min(char1, char2);
        int end = Math.max(char1,char2);
        for (int i = start + 1; i < end; i++) {
            System.out.print((char) i + " ");
        }
    }
}
