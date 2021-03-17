import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "[starSTAR]";
        Pattern pattern = Pattern.compile(regex);

        String regex1 = "@([a-zA-Z]+)[^@\\-!:>]*\\:(\\d+)[^@\\-!:>]*\\!(\\A|\\D)\\![^@\\-!:>]*->([\\d]+)";
        Pattern pattern1 = Pattern.compile(regex1);

        List<String> attack = new ArrayList<>();
        List<String> destruction = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int count = 0;
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                count++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                stringBuilder.append((char) (input.charAt(j) - count));
            }

            Matcher matcher1 = pattern1.matcher(stringBuilder.toString());
            while (matcher1.find()){
                String name = matcher1.group(1);
                String type = matcher1.group(3);
                if (type.equals("A")){
                    attack.add(name);
                }else {
                    destruction.add(name);
                }
            }
        }

        System.out.println("Attacked planets: " + attack.size());
        attack.stream().sorted((f, s) -> f.compareTo(s)).forEach(e -> System.out.println("-> " + e));

        System.out.println("Destroyed planets: " + destruction.size());
        destruction.stream().sorted((f,s) -> f.compareTo(s)). forEach(e -> System.out.println("-> " + e));
    }
}
