import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> keyMaterials = new HashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();
        boolean isObtained = false;

        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);
        keyMaterials.put("motes", 0);
        while (!isObtained) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i+=2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (material.equals("fragments") || material.equals("shards") || material.equals("motes")){
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);

                    if (keyMaterials.get(material) >= 250){
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        if (material.equals("fragments")){
                            System.out.println("Valanyr obtained!");
                        }else if (material.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        }else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        isObtained = true;
                        break;
                    }
                }else {
                    junk.putIfAbsent(material, 0);
                    junk.put(material, junk.get(material) + quantity);
                }
            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0){
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junk.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
