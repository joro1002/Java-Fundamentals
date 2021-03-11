import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Character, Integer> chars = new LinkedHashMap<>();
        String input = scanner.nextLine();

        for (Character c:
             input.toCharArray()) {
            if (c != ' '){
                chars.putIfAbsent(c, 0);
                chars.put(c, chars.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> es : chars.entrySet()) {
            System.out.println(es.getKey() + " -> " + es.getValue());
        }

    }
}
