import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex = "(\\||\\#)([a-zA-Z ]+)\\1(([0-9]{2})\\/([0-9]{2})\\/([0-9]{2}))\\1(\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher =pattern.matcher(input);
        int countDay = 0;
        int sum = 0;

        List<String> result = new ArrayList<>();
        while (matcher.find()){
            int currentCalories = Integer.parseInt(matcher.group(7));
            sum += currentCalories;
            countDay = sum / 2000;
            result.add(String.format("Item: %s, Best before: %s, Nutrition: %d",
                    matcher.group(2), matcher.group(3),currentCalories));
        }
        System.out.printf("You have food to last you for: %d days!%n", countDay);
        for (String item:
             result) {
            System.out.println(item);
        }
    }
}
