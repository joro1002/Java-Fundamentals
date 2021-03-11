import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] warship = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maximumHealth = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Retire")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);

                    if (index >= 0 && index <= warship.length - 1) {
                        warship[index] = warship[index] - damage;
                        if (warship[index] <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damageDefend = Integer.parseInt(tokens[3]);

                    if (startIndex >= 0 && startIndex <= pirateShip.length - 1
                            && endIndex >= 0 && endIndex <= pirateShip.length - 1) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] = pirateShip[i] - damageDefend;

                            if (pirateShip[i] <= 0){
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexRepair = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);

                    if (indexRepair >= 0 && indexRepair <= pirateShip.length - 1){
                        pirateShip[indexRepair] = pirateShip[indexRepair] + health;
                        if (pirateShip[indexRepair] > maximumHealth){
                            pirateShip[indexRepair] = maximumHealth;
                        }
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (int i = 0; i < pirateShip.length; i++) {
                        if (pirateShip[i] < 0.2 * maximumHealth){
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }


            command = scanner.nextLine();
        }

        int sumPirate = 0;
        for (int i = 0; i < pirateShip.length; i++) {
            sumPirate += pirateShip[i];
        }

        int sumWarship = 0;
        for (int i = 0; i < warship.length; i++) {
            sumWarship += warship[i];
        }

        System.out.printf("Pirate ship status: %d%n", sumPirate);
        System.out.printf("Warship status: %d", sumWarship);
    }
}
