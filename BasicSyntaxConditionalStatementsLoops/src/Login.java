import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String reversedUsername = new StringBuilder(username).reverse().toString();

        int count = 0;
        String password = scanner.nextLine();

        while (true){
            if (!password.equals(reversedUsername)){
                count++;
                if (count == 4){
                    System.out.printf("User %s blocked!", username);
                    break;
                }
                System.out.println("Incorrect password. Try again.");
            }else {
                System.out.printf("User %s logged in.", username);
                break;
            }
            password = scanner.nextLine();
        }
    }
}
