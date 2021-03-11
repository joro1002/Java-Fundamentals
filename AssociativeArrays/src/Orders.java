import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, List<Double>> items = new LinkedHashMap<>();

        while (!command.equals("buy")) {
            String[] tokens = command.split("\\s+");
            String name = tokens[0];
            Double price = Double.parseDouble(tokens[1]);
            Double quantity = Double.parseDouble(tokens[2]);

            if (!items.containsKey(name)) {
                items.put(name, new ArrayList<>());
                items.get(name).add(price);
                items.get(name).add(quantity);
            }else {
                items.get(name).set(0, price);
                double newQuantity = items.get(name).get(1) + quantity;
                items.get(name).set(1, newQuantity);
            }
            command = scanner.nextLine();
        }
        items.entrySet()
                .forEach(e -> System.out.println(String.format("%s -> %.2f",
                        e.getKey(),e.getValue().get(0) * e.getValue().get(1))));
    }
}
