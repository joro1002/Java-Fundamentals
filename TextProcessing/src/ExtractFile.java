import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        String name = path.substring(path.lastIndexOf("\\") + 1, path.lastIndexOf("."));
        String extension = path.substring(path.lastIndexOf(".") + 1);

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);
    }
}
