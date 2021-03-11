package Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();
        while (!command.equals("End")){
            String[] tokens = command.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);

            Vehicle vehicle = new Vehicle(type, model, color,horsepower);
            if (type.equals("car")){
                cars.add(vehicle);
            }else if (type.equals("truck")){
                trucks.add(vehicle);
            }

            command = scanner.nextLine();
        }
        String commandTwo =scanner.nextLine();

        while (!commandTwo.equals("Close the Catalogue")){
            String model = commandTwo;

            for (Vehicle car:
                    cars) {
                if (car.getModel().equals(model)){
                    System.out.println(car.toString());
                }
            }

            for (Vehicle truck:
                    trucks) {
                if (truck.getModel().equals(model)){
                    System.out.println(truck.toString());
                }
            }
            commandTwo = scanner.nextLine();
        }
        double truckSum = 0;
        double truckAvg = 0;
        double carSum = 0;
        double carAvg = 0;

        if(!cars.isEmpty()){
            for (Vehicle car : cars) {
                carSum += car.getHorsepower();
            }
            carAvg = carSum / cars.size();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n",carAvg);
        if(!trucks.isEmpty()){
            for (Vehicle truck : trucks) {
                truckSum += truck.getHorsepower();
            }
            truckAvg = truckSum / trucks.size();
        }
        System.out.printf("Trucks have average horsepower of: %.2f.",truckAvg);

    }
}
