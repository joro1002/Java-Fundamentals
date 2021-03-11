import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chests = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        if (!chests.contains(tokens[i])) {
                            chests.add(0, tokens[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index <= chests.size() - 1) {
                        chests.add(chests.get(index));
                        chests.remove(index);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    List<String> newList = new ArrayList<>();
                    if (count >= chests.size()) {
                        for (String chest :
                                chests) {
                            newList.add(chest);
                        }
                        chests.clear();
                    } else {
                        for (int i = 0; i < count; i++) {
                            String currentLast = chests.get(chests.size() - 1);

                            newList.add(currentLast);
                            chests.remove(currentLast);
                        }
                        Collections.reverse(newList);
                    }
                    String result = String.join(", ", newList);
                    System.out.println(result);
                    break;
            }

            command = scanner.nextLine();
        }

        int sum = 0;
        for (String chest : chests) {
            sum += chest.length();
        }

        if (chests.isEmpty()){
            System.out.println("Failed treasure hunt.");
        }else {
            double average = (double) sum / chests.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", average);
        }
    }
}
