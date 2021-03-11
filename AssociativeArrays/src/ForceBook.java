import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<String>> users = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Lumpawaroo")) {
            String[] tokens = null;
            if (command.contains("|")) {
                tokens = command.split(" \\| ");
                String forceSide = tokens[0];
                String forceUser = tokens[1];

                users.putIfAbsent(forceSide, new ArrayList<>());
                if (!users.get(forceSide).contains(forceUser)) {
                    users.get(forceSide).add(forceUser);
                }


            } else {
                tokens = command.split(" -> ");
                String forceSide = tokens[1];
                String forceUser = tokens[0];
                boolean flag = false;

                for (Map.Entry<String, List<String>> entry : users.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        entry.getValue().remove(forceUser);
                        users.putIfAbsent(forceSide, new ArrayList<>());
                        users.get(forceSide).add(forceUser);
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    users.putIfAbsent(forceSide, new ArrayList<>());
                    if (!users.get(forceSide).contains(forceUser)){
                        users.get(forceSide).add(forceUser);
                    }
                }
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

            }


            command = scanner.nextLine();
        }
        users.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().size() - f.getValue().size();
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(e -> {
            if (e.getValue().size() >0) {
                System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                e.getValue()
                        .stream()
                        .sorted((f, s) -> f.compareTo(s))
                        .forEach(u -> System.out.println("! " + u));
            }
        });

    }
}
