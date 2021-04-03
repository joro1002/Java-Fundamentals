import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String numberRegex = "[\\d]";
        String emojisRegex = "([\\:||\\**])\\1([A-Z][a-z]{2,})\\1\\1";
        Pattern numberPattern = Pattern.compile(numberRegex);
        Pattern emojisPattern = Pattern.compile(emojisRegex);

        Matcher numberMatcher = numberPattern.matcher(input);
        long coolThreshold = 1;

        while (numberMatcher.find()) {
            coolThreshold *= Integer.parseInt(numberMatcher.group());
        }
        System.out.println("Cool threshold: " + coolThreshold);

        Matcher emojis = emojisPattern.matcher(input);

        List<String> verifyEmoji = new ArrayList<>();
        int count = 0;
        while (emojis.find()){
            count++;
           String emoji = emojis.group(2);
           int sum = 0;
            for (int i = 0; i < emoji.length(); i++) {
                sum += emoji.charAt(i);
            }
            if (sum >= coolThreshold){
                verifyEmoji.add(emojis.group());
            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", count);
        verifyEmoji.stream().forEach(System.out::println);
    }
}
