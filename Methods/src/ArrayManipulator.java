import java.util.*;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "exchange":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < numbers.length) {
                        numbers = exchange(numbers, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "max":
                    if (tokens[1].equals("even")) {
                        maxEven(numbers);
                    } else if (tokens[1].equals("odd")) {
                        maxOdd(numbers);
                    }
                    break;

                case "min":
                    if (tokens[1].equals("even")) {
                        minEven(numbers);
                    } else if (tokens[1].equals("odd")) {
                        minOdd(numbers);
                    }
                    break;

                case "first":
                    if (tokens[2].equals("even")) {
                        int count = Integer.parseInt(tokens[1]);
                        firstCountEven(numbers, count);

                    } else if (tokens[2].equals("odd")) {
                        int count = Integer.parseInt(tokens[1]);
                        firstCountOdd(numbers, count);
                    }
                    break;

                case "last":
                    if (tokens[2].equals("even")) {
                        int count = Integer.parseInt(tokens[1]);
                        lastCountEven(numbers, count);
                    } else if (tokens[2].equals("odd")) {
                        int count = Integer.parseInt(tokens[1]);
                        lastCountOdd(numbers, count);
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1){
                System.out.print(numbers[i]);
            }else {
                System.out.print(numbers[i] + ", ");
            }
        }
        System.out.print("]");

    }

    public static int[] exchange(int[] numbers, int index) {
        int[] arr = new int[numbers.length];
        int count = 0;

        for (int i = index + 1; i < numbers.length; i++) {
            arr[count] = numbers[i];
            count++;
        }
        for (int i = 0; i < index + 1; i++) {
            arr[count] = numbers[i];
            count++;
        }
        return arr;
    }

    public static void maxEven(int[] numbers) {
        int maxEven = Integer.MIN_VALUE;
        int indexMaxEven = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0 && numbers[i] >= maxEven) {
                maxEven = numbers[i];
                indexMaxEven = i;
            }
        }
        if (indexMaxEven > -1) {
            System.out.println(indexMaxEven);
        } else {
            System.out.println("No matches");
        }
    }

    public static void maxOdd(int[] numbers) {
        int maxOdd = Integer.MIN_VALUE;
        int indexMaxOdd = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1 && numbers[i] >= maxOdd) {
                maxOdd = numbers[i];
                indexMaxOdd = i;
            }
        }
        if (indexMaxOdd > -1) {
            System.out.println(indexMaxOdd);
        } else {
            System.out.println("No matches");
        }
    }

    public static void minEven(int[] numbers) {
        int minEven = Integer.MAX_VALUE;
        int indexMinEven = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0 && numbers[i] <= minEven) {
                minEven = numbers[i];
                indexMinEven = i;
            }
        }
        if (indexMinEven > -1) {
            System.out.println(indexMinEven);
        } else {
            System.out.println("No matches");
        }
    }

    public static void minOdd(int[] numbers) {
        int minOdd = Integer.MAX_VALUE;
        int indexMinOdd = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1 && numbers[i] <= minOdd) {
                minOdd = numbers[i];
                indexMinOdd = i;
            }
        }
        if (indexMinOdd > -1) {
            System.out.println(indexMinOdd);
        } else {
            System.out.println("No matches");
        }
    }

    public static void firstCountEven(int[] numbers, int count) {
        List<Integer> first = new ArrayList<>();
        int countIndex = 0;

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] % 2 == 0 && countIndex < count) {
                first.add(countIndex, numbers[index]);
                countIndex++;
            }
        }
        if (count > numbers.length) {
            System.out.println("Invalid count");
        } else if (first.size() > 0) {
            System.out.print("[");
            int lastElement = first.get(first.size() - 1);
            first.remove(first.size() - 1);
            for (int numer:
                 first) {
                System.out.print(numer + ", ");
            }
            System.out.print(lastElement);
            System.out.print("]");
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

    public static void firstCountOdd(int[] numbers, int count) {
        List<Integer> first = new ArrayList<>();
        int countIndex = 0;

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] % 2 == 1 && countIndex < count) {
                first.add(countIndex, numbers[index]);
                countIndex++;
            }
        }
        if (count > numbers.length) {
            System.out.println("Invalid count");
        } else if (first.size() > 0) {
            System.out.print("[");
            int lastElement = first.get(first.size() - 1);
            first.remove(first.size() - 1);
            for (int numer:
                    first) {
                System.out.print(numer + ", ");
            }
            System.out.print(lastElement);
            System.out.print("]");
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

    public static void lastCountEven(int[] numbers, int count) {
        List<Integer> first = new ArrayList<>();
        int countIndex = 0;

        for (int index = numbers.length - 1; index >= 0; index--) {
            if (numbers[index] % 2 == 0 && countIndex < count) {
                first.add(countIndex, numbers[index]);
                countIndex++;
            }
        }
        Collections.reverse(first);
        if (count > numbers.length) {
            System.out.println("Invalid count");
        } else if (first.size() > 0) {
            System.out.print("[");
            int lastElement = first.get(first.size() - 1);
            first.remove(first.size() - 1);
            for (int numer:
                    first) {
                System.out.print(numer + ", ");
            }
            System.out.print(lastElement);
            System.out.print("]");
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

    public static void lastCountOdd(int[] numbers, int count) {
        List<Integer> first = new ArrayList<>();
        int countIndex = 0;

        for (int index = numbers.length - 1; index >= 0; index--) {
            if (numbers[index] % 2 == 1 && countIndex < count) {
                first.add(countIndex, numbers[index]);
                countIndex++;
            }
        }
        Collections.reverse(first);
        if (count > numbers.length) {
            System.out.println("Invalid count");
        } else if (first.size() > 0) {
            System.out.print("[");
            int lastElement = first.get(first.size() - 1);
            first.remove(first.size() - 1);
            for (int numer:
                    first) {
                System.out.print(numer + ", ");
            }
            System.out.print(lastElement);
            System.out.print("]");
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }
}
