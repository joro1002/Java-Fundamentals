import javax.security.sasl.SaslClient;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> task = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("stop")){
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());

            task.putIfAbsent(resource, 0);
            task.put(resource, task.get(resource) + quantity);

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> es : task.entrySet()) {
            System.out.println(es.getKey() + " -> " + es.getValue());
        }

    }
}
