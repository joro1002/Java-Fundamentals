import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleToLongFunction;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|+");

        int health = 100;
        int bitcoins = 0;
        int count = 0;
        boolean isALive = true;
        for (int i = 0; i < rooms.length; i++) {
            String[] tokens = rooms[i].split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);
            count++;

            if (command.equals("potion")) {
                int currentHealth = health;
                health += number;
                if (health >= 100) {
                    health = 100;
                    System.out.printf("You healed for %d hp.%n", health - currentHealth);
                }else {
                    System.out.printf("You healed for %d hp.%n", number);
                }
                System.out.printf("Current health: %d hp.%n", health);
            } else if (command.equals("chest")) {
                bitcoins += number;
                System.out.printf("You found %d bitcoins.%n", number);
            } else {
                health -= number;
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", command);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    isALive = false;
                    break;
                }
            }
        }
        if (isALive){
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", health);
        }else {
            System.out.printf("Best room: %d%n", count);
        }
    }
}
