package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articles = scanner.nextLine().split(",\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        Articles articles1 = new Articles(articles[0], articles[1], articles[2]);

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(": ");

            switch (tokens[0]) {
                case "Edit":
                    articles1.Edit(tokens[1]);
                    break;
                case "ChangeAuthor":
                    articles1.ChangeAuthor(tokens[1]);
                    break;
                case "Rename":
                    articles1.Rename(tokens[1]);
                    break;
            }
        }
        System.out.println(articles1.toString());
    }
}
