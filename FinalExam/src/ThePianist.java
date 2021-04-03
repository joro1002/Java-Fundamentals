import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> piecesComposer = new TreeMap<>();
        Map<String, String> piecesKey = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");

            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            piecesComposer.put(piece, composer);
            piecesKey.put(piece,key);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] tokens = command.split("\\|");

            String piece = tokens[1];

            switch (tokens[0]) {
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];

                    if (piecesComposer.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        piecesComposer.put(piece, composer);
                        piecesKey.put(piece, key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;

                case "Remove":
                    if (piecesComposer.containsKey(piece)) {
                        piecesComposer.remove(piece);
                        piecesKey.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;

                case "ChangeKey":
                    String newKey = tokens[2];

                    if (piecesComposer.containsKey(piece)) {
                       piecesKey.put(piece, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : piecesComposer.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue(), piecesKey.get(entry.getKey()));
        }

    }
}
