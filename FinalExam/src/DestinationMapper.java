import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(\\=|\\/)([A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        List<String> travel = new ArrayList<>();
        int travelPoint = 0;

        while (matcher.find()){
           String current = matcher.group(2);
           travelPoint += current.length();
           travel.add(current);
        }
        System.out.print("Destinations: ");
        for (int i = 0; i < travel.size() ; i++) {
            if (i == travel.size() - 1){
                System.out.print(travel.get(i));
            }else {
                System.out.print(travel.get(i) + ", ");
            }
        }
        System.out.println();
        System.out.println("Travel Points: " + travelPoint);
    }
}
