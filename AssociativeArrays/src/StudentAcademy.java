import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(name)){
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            }else {
                students.get(name).add(grade);
            }
        }

        students.entrySet()
                .stream()
                .sorted((f,s) ->{
                    double first = f.getValue()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .getAsDouble();
                    double second = s.getValue()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .getAsDouble();
                    return Double.compare(second, first);
                })
                .forEach(e -> {
                    double average = e.getValue()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .getAsDouble();
                    if (average >= 4.5){
                        System.out.printf("%s -> %.2f%n", e.getKey(), average);
                    }
                });
    }
}
