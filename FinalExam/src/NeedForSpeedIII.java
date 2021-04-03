import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> mileages = new TreeMap<>();
        Map<String, Integer> fuels = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String car = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            mileages.putIfAbsent(car, 0);
            mileages.put(car, mileage);

            fuels.putIfAbsent(car, 0);
            fuels.put(car, fuel);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] tokens = command.split(" : ");
            String car = tokens[1];

            switch (tokens[0]) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if (fuels.get(car) < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        mileages.put(car, mileages.get(car) + distance);
                        fuels.put(car, fuels.get(car) - fuel);

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);

                        if (mileages.get(car) > 100000) {
                            mileages.remove(car);
                            fuels.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    }
                    break;
                case "Refuel":
                    int fuelCar = Integer.parseInt(tokens[2]);

                    if (fuels.get(car) < 75) {
                        int current = fuels.get(car);
                        int increaseFuel = current + fuelCar;
                        if (increaseFuel > 75) {
                            increaseFuel = 75;
                        }
                        fuels.put(car, increaseFuel);
                        System.out.printf("%s refueled with %d liters%n", car, increaseFuel - current);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);

                    mileages.put(car, mileages.get(car) - kilometers);

                    if (mileages.get(car) < 10000) {
                        mileages.put(car, 10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        mileages.entrySet().stream()
                .sorted((f,s) -> s.getValue().compareTo(f.getValue()))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
                        ,e.getKey(), e.getValue(), fuels.get(e.getKey())));
    }
}
