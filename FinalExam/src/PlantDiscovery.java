import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plants = new LinkedHashMap<>();
        Map<String, Double> plantsRating = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            if (!plants.containsKey(plant)) {
                plants.putIfAbsent(plant, 0);
                plants.put(plant, rarity);
            } else {
                plants.put(plant, plants.get(plant) + rarity);
            }

        }
        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {
            String[] tokens = command.split(": ");
            String[] commands = tokens[1].split(" - ");
            String plant = commands[0];

            switch (tokens[0]) {
                case "Rate":
                    int rating = Integer.parseInt(commands[1]);
                    plantsRating.putIfAbsent(plant, 0.0);
                    plantsRating.put(plant, plantsRating.get(plant) + rating);
                    break;

                case "Update":
                    int newRarity = Integer.parseInt(commands[1]);
                    plants.put(plant, newRarity);
                    break;
                case "Reset":
                    plantsRating.put(plant, 0.0);
                    break;
                default:
                    System.out.println("error");
                    break;
            }

            command = scanner.nextLine();
        }


    }
}
