import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String regex = "[^\\.\\-\\_]*[A-Za-z]*[0-9]*\\.?\\-?\\_?[A-Za-z]*[0-9]*[^\\.\\-\\_]\\@([a-zA-Z]+([\\.\\-_][A-Za-z]+)+)";

        Pattern pattern = Pattern.compile(regex);

        for (String text:
             input) {
            Matcher matcher = pattern.matcher(text);
           while (matcher.find()){
               System.out.println(matcher.group());
           }
        }
    }
}
