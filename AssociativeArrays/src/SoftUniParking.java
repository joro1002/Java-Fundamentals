import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String username = tokens[1];
            switch (command) {
                case "register":
                    String plateNumber = tokens[2];
                    if (users.containsKey(username)){
                        System.out.println("ERROR: already registered with plate number " + plateNumber);
                    }else {
                        users.put(username, plateNumber);
                        System.out.printf("%s registered %s successfully%n", username, plateNumber);
                    }
                    break;
                case "unregister":
                    if (users.containsKey(username)){
                        users.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
            }
        }
        users.entrySet()
                .forEach(e -> System.out.println(e.getKey() + " => " + e.getValue()));
    }
}
