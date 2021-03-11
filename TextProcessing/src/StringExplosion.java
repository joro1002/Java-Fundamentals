import javax.swing.*;
import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol == '>'){
                builder.append('>');
                i++;
                int explosion = text.charAt(i) - '0';
                explosion--;
                while (explosion > 0 && i  < text.length() - 1){
                    i++;
                    symbol = text.charAt(i);
                    if (symbol == '>'){
                        builder.append(symbol);
                        i++;
                        explosion += text.charAt(i) - '0' - 1;
                        continue;
                    }
                        explosion--;

                }
            }else {
                builder.append(symbol);
            }
        }
        System.out.println(builder.toString());
    }
}
