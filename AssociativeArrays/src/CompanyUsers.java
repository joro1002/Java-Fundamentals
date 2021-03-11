import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        TreeMap<String, List<String>> company = new TreeMap<>();

        while (!command.equals("End")){
            String[] tokens = command.split(" -> ");
            String name = tokens[0];
            String id = tokens[1];

            if (!company.containsKey(name)){
                company.put(name, new ArrayList<>());
                company.get(name).add(id);
            }else {
                if (!company.get(name).contains(id)) {
                    company.get(name).add(id);
                }
            }
            command = scanner.nextLine();
        }
        company.entrySet()
                .stream()
                .sorted((f,s) -> {
                    int result = f.getKey().compareTo(s.getKey());
                    return result;
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue()
                            .stream()
                            .forEach(s -> System.out.println("-- " + s));
                });
    }
}
