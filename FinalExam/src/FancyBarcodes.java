import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String regex = "(\\@\\#+)([A-Z][A-Za-z0-9]{4,}[A-Z])(\\@\\#+)";
        String digits = "[\\d]";
        Pattern pattern = Pattern.compile(regex);
        Pattern patternDigits = Pattern.compile(digits);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            Matcher matcherDigits = patternDigits.matcher(input);

            String sum = "";
            boolean isDigit = false;
            boolean isValid = false;
            while (matcher.find()){
                isValid = true;
                while (matcherDigits.find()){
                    sum += matcherDigits.group();
                    isDigit = true;
                }
                if (isDigit){
                    System.out.println("Product group: " + sum);
                }else {
                    System.out.println("Product group: 00");
                }
            }
            if (!isValid){
                System.out.println("Invalid barcode");
            }
        }
    }
}
