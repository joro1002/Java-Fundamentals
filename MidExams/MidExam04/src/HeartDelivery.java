import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        int index = 0;

        while (!command.equals("Love!")) {
            String[] tokens = command.split("\\s+");
            int jumpLength = Integer.parseInt(tokens[1]);

            index += jumpLength;

            if (index >= neighborhood.length) {
                index = 0;
            }
            if (neighborhood[index] != 0) {
                neighborhood[index] -= 2;
                if (neighborhood[index] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", index);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", index);
            }


            command = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", index);

        boolean missionSuccessful = true;

        for (int neigh :
                neighborhood) {
            if (neigh != 0) {
                missionSuccessful = false;
            }
        }

        int count = 0;
        for (int neigh:
             neighborhood) {
            if (neigh != 0){
                count++;
            }
        }
        if (missionSuccessful){
            System.out.println("Mission was successful.");
        }else {
            System.out.printf("Cupid has failed %d places.", count);
        }
    }
}
