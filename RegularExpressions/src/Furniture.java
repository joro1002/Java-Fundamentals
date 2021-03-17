import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>([A-Za-z]+)<<([\\d]+\\.?[\\d]+)\\!([\\d]+)";

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        List<String> names = new ArrayList<>();

        double allPrice = 0;
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                int quantity = Integer.parseInt(matcher.group(3));
                names.add(name);
                allPrice += price * quantity;
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String name:
             names) {
            System.out.println(name);
        }
        System.out.printf("Total money spend: %.2f", allPrice);
    }
}
