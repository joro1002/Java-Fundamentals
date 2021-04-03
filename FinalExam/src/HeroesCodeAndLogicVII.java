import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> heroHP = new TreeMap<>();
        TreeMap<String, Integer> heroMp = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String heroName = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);

            if (hp <= 100) {
                heroHP.put(heroName, hp);
            }

            if (mp <= 200) {
                heroMp.put(heroName, mp);
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" - ");
            String heroName = tokens[1];

            switch (tokens[0]) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    int currentMp = heroMp.get(heroName);

                    if (currentMp >= mpNeeded) {
                        heroMp.put(heroName, currentMp - mpNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentMp - mpNeeded);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    int currentHp = heroHP.get(heroName) - damage;

                    if (currentHp > 0) {
                        heroHP.put(heroName, currentHp);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHp);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroHP.remove(heroName);
                    }

                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);

                    int currentMP = heroMp.get(heroName);
                    int increaseMP = currentMP + amount;

                    if (increaseMP > 200) {
                        increaseMP = 200;
                    }
                    heroMp.put(heroName, increaseMP);
                    System.out.printf("%s recharged for %d MP!%n", heroName, increaseMP - currentMP);
                    break;
                case "Heal":
                    int amountHeal = Integer.parseInt(tokens[2]);
                    int currentHP = heroHP.get(heroName);
                    int current = currentHP + amountHeal;

                    if (current > 100) {
                        current = 100;
                    }
                    heroHP.put(heroName, current);
                    System.out.printf("%s healed for %d HP!%n", heroName, heroHP.get(heroName) - currentHP);
                    break;
            }


            command = scanner.nextLine();
        }
        heroHP.entrySet().stream()
                .sorted((f,s) -> s.getValue().compareTo(f.getValue()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.println(" HP: " + e.getValue());
                    System.out.println(" MP: " + heroMp.get(e.getKey()));

                });
    }
}
