import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        LinkedHashMap<String, Integer> race = new LinkedHashMap<>();

        String regexName = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(regexName);

        String regexKm = "\\d";
        Pattern pattern1 = Pattern.compile(regexKm);

        for (String name :
                names) {
            race.putIfAbsent(name, 0);
        }

        StringBuilder builderName = new StringBuilder();
        int km = 0;
        while (!command.equals("end of race")) {
            Matcher matcher = pattern.matcher(command);
            while (matcher.find()) {
                builderName.append(matcher.group());
            }

            Matcher matcher1 = pattern1.matcher(command);
            int current = 0;
            while (matcher1.find()) {
                km += Integer.parseInt(matcher1.group());
                current += Integer.parseInt(matcher1.group());
            }

            if (race.containsKey(builderName.toString())) {
                if (race.containsKey(builderName.toString()) && race.get(builderName.toString()) > 0) {
                    race.put(builderName.toString(), race.get(builderName.toString()) + current);
                } else {
                    race.put(builderName.toString(), km);
                }
            }

            builderName.setLength(0);
            km = 0;
            command = scanner.nextLine();
        }

        List<String> result = race.entrySet()
                .stream()
                .sorted((f,s) -> s.getValue().compareTo(f.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        for (int i = 0; i < result.size(); i++) {
            if (i == 0) {
                System.out.printf("%dst place: %s%n", i + 1, result.get(i));
            }
            if (i == 1){
                System.out.printf("%dnd place: %s%n", i + 1, result.get(i));
            }
            if (i == 2){
                System.out.printf("%drd place: %s%n", i + 1, result.get(i));
            }
        }

    }
}
