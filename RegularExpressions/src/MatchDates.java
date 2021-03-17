import javax.security.sasl.SaslClient;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([\\d]{2})(\\/|\\-|\\.)([A-z][a-z]{2})\\2([\\d]{4})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(String.format("Day: %s, Month: %s, Year: %s", matcher.group(1), matcher.group(3), matcher.group(4)));
        }
    }
}
