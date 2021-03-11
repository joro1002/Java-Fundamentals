import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distancesPokemon = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!distancesPokemon.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());

            int indexToRemove = 0;

            if (index < 0) {
                indexToRemove = distancesPokemon.remove(0);
                sum += indexToRemove;
                distancesPokemon.add(0, distancesPokemon.get(distancesPokemon.size() - 1));
            } else if (index > distancesPokemon.size() - 1) {
                indexToRemove = distancesPokemon.remove(distancesPokemon.size() - 1);
                sum += indexToRemove;
                distancesPokemon.add(distancesPokemon.get(0));
            } else {
                indexToRemove = distancesPokemon.remove(index);
                sum += indexToRemove;
            }

            for (int i = 0; i < distancesPokemon.size(); i++) {
                if (distancesPokemon.get(i) <= indexToRemove) {
                    distancesPokemon.set(i, distancesPokemon.get(i) + indexToRemove);
                } else if (distancesPokemon.get(i) > indexToRemove) {
                    distancesPokemon.set(i, distancesPokemon.get(i) - indexToRemove);
                }
            }
        }
        System.out.println(sum);
    }
}
