import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        middleCharacters(text);
    }

    public static void middleCharacters(String text){
        char result1 = ' ';
        char result2 = ' ';

        if (text.length() % 2 ==0){
            result1 = text.charAt(text.length() / 2 - 1);
            result2 = text.charAt(text.length() / 2);
            System.out.print(result1 + "" + result2);
        }else {
            System.out.println(text.charAt(text.length() / 2));
        }
    }
}
