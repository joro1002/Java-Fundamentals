import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> users = new HashMap<>();
        HashMap<String, Integer> languages = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("exam finished")) {
            String[] tokens = command.split("-");
            String username = tokens[0];
            String language = tokens[1];
            if (language.equals("banned")){
                users.remove(username);
                command = scanner.nextLine();
                continue;
            }
            int points = Integer.parseInt(tokens[2]);

            if (!users.containsKey(username)) {
                users.put(username, points);
            } else {
                int currentPoint = users.get(username);
                if (points > currentPoint) {
                    users.put(username, points);
                }
            }
            languages.putIfAbsent(language, 0);
            languages.put(language, languages.get(language) + 1);

            command = scanner.nextLine();
        }
        System.out.println("Results:");
        users.entrySet()
                .stream()
                .sorted((f,s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0){
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(e-> {
                    System.out.printf("%s | %d%n", e.getKey(),e.getValue());
                });
        System.out.println("Submissions:");

        languages.entrySet()
                .stream()
                .sorted((f,s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0){
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(l -> System.out.printf("%s - %d%n", l.getKey(), l.getValue()));

    }
}
