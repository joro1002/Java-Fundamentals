import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<Integer>> map = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("Sail")) {
            String[] tokens = command.split("\\|+");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (map.containsKey(city)) {
                List<Integer> current = map.get(city);
                int currentPopulation = current.get(0);
                int currentGold = current.get(1);
                current.set(0, currentPopulation + population);
                current.set(1, currentGold + gold);

                map.put(city, current);
            } else {
                map.put(city, Arrays.asList(population, gold));
            }
            command = scanner.nextLine();
        }
        command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("=>");
            if (tokens[0].equals("Plunder")) {
                String town = tokens[1];
                int people = Integer.parseInt(tokens[2]);
                int gold = Integer.parseInt(tokens[3]);

                List<Integer> current = map.get(town);
                int currentPeople = current.get(0);
                int currentGold = current.get(1);

                current.set(0, currentPeople - people);
                current.set(1, currentGold - gold);
                map.put(town, current);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                if (current.get(0) <= 0 || current.get(1) <= 0) {
                    System.out.printf("%s has been wiped off the map!%n", town);
                    map.remove(town);
                }
            } else if (tokens[0].equals("Prosper")) {
                String town = tokens[1];
                int gold = Integer.parseInt(tokens[2]);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                    command = scanner.nextLine();
                    continue;
                }
                List<Integer> current = map.get(town);

                int currentGold = current.get(1);
                current.set(1, currentGold + gold);
                map.put(town, current);
                System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, current.get(1));
            }


            command = scanner.nextLine();
        }

        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", map.size());
        map.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().get(1).compareTo(f.getValue().get(1));
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        })
                .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        e.getKey(), e.getValue().get(0), e.getValue().get(1)));
    }
}
