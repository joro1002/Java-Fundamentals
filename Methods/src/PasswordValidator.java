import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        boolean between6And10Characters = between6And10Characters(password);
        boolean consistsLettersAndDigits = consistsLettersAndDigits(password);
        boolean twoDigits = twoDigits(password);
        if (between6And10Characters && consistsLettersAndDigits && twoDigits){
            System.out.println("Password is valid");
        }

    }

    public static boolean between6And10Characters(String password){
        if (password.length() >= 6 && password.length() <=10){
            return true;
        }
        System.out.println("Password must be between 6 and 10 characters");
        return false;
    }

    public static boolean consistsLettersAndDigits(String password){
        int count = 0;
        for (int i = 0; i < password.length(); i++) {

            if (password.charAt(i) >= 48 && password.charAt(i) <=57 ){
                count++;
            }else if (password.charAt(i) >= 65 && password.charAt(i) <= 90){
                count++;
            }else if (password.charAt(i) >=97 && password.charAt(i) <=122){
                count++;
            }
        }
        if (count == password.length()){
            return true;
        }
        System.out.println("Password must consist only of letters and digits");
        return false;
    }

    public static boolean twoDigits(String password){
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57){
                count++;
            }
        }
        if (count >= 2){
            return true;
        }
        System.out.println("Password must have at least 2 digits");
        return false;
    }
}
