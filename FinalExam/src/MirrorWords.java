import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(\\@|\\#)([a-zA-Z]{3,})\\1\\1([a-zA-Z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> mirrorWords = new ArrayList<>();

        boolean validWord = false;
        boolean mirrorWord = false;
        int count = 0;

        while (matcher.find()){
            validWord = true;
            count++;
            String first = matcher.group(2);
            String second = matcher.group(3);
            StringBuilder reverseWord = new StringBuilder();
            reverseWord.append(second).reverse();

            if (first.equals(reverseWord.toString())){
                mirrorWord = true;
               mirrorWords.add(first + " <=> " + second);
            }

        }
        if (!validWord){
            System.out.println("No word pairs found!");
        }else {
            System.out.printf("%d word pairs found!%n", count);
        }

        if (!mirrorWord){
            System.out.println("No mirror words!");
        }else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < mirrorWords.size(); i++) {
                if (i == mirrorWords.size() - 1){
                    System.out.print(mirrorWords.get(i));
                }else {
                    System.out.print(mirrorWords.get(i) + ", ");
                }
            }
        }
    }
}
