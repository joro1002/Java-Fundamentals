import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();

        BigInteger bigInteger = new BigInteger("0");
        BigInteger a = new BigInteger(first);
        BigInteger b = new BigInteger(second);
        bigInteger = a.multiply(b);
        System.out.println(bigInteger);


    }
}
