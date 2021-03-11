package OrderAge;

import javax.sql.rowset.serial.SerialStruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Person> personList = new ArrayList<>();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String name = tokens[0];
            String ID = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Person person = new Person(name, ID, age);
            personList.add(person);

            command = scanner.nextLine();
        }
        personList = personList.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        for (Person person :
                personList) {
            System.out.println(person.toString());
        }
    }
}
