import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cookies = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Eat")) {
            String[] tokens = command.split("\\s+");
            String biscuit = tokens[1];

            switch (tokens[0]) {
                case "Update-Any":
                    if (cookies.contains(biscuit)){
                        cookies.set(cookies.indexOf(biscuit), "Out of stock");
                    }
                    break;
                case "Remove":
                    int index =Integer.parseInt(tokens[2]);
                    if (index >= 0 && index <= cookies.size() - 1){
                        cookies.set(index, biscuit);
                    }
                    break;
                case "Update-Last":
                    cookies.set(cookies.size() - 1, biscuit);
                    break;
                case "Rearrange":
                    if (cookies.contains(biscuit)){
                        cookies.remove(biscuit);
                        cookies.add(biscuit);
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        for (int i = 0; i < cookies.size(); i++) {
            if (cookies.get(i).equals("Out of stock")){
                System.out.print("");
            }else{
                System.out.print(cookies.get(i) + " ");
            }
        }
    }
}
