import java.util.Scanner;

public class SimpleNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите положительное целое число !=0 (например 1 или 15589) :");
        int examinedNumber = scanner.nextInt();

        System.out.println("Введите количество простых чисел в выводимой строке.");
        System.out.println("Наиболее наглядно сделать количество от 5 до 35 : ");
        int printLineSize = scanner.nextInt();

        printSimpleNumbers(examinedNumber, printLineSize);
    }

    private static void printSimpleNumbers(int examinedNumber, int printLineSize) {
        int countNumbersInLine = 1;
        String output;
        int simpleNumbersQuantity = 0;

        for (int i = 1; i <= examinedNumber; i++) {

            if (isNumberSimple(i)) {
                ++simpleNumbersQuantity;
                output = (countNumbersInLine == printLineSize) ? "%d;%n" : "%d; ";
                countNumbersInLine = (countNumbersInLine == printLineSize) ? 1 : ++countNumbersInLine;
                System.out.printf(output, i);
            }
        }

        System.out.printf("Количество найденных простых чисел равно %d.%n", simpleNumbersQuantity);
    }

    private static boolean isNumberSimple(int examinedNumber) {
        if (examinedNumber <= 3) {
            return true;
        }

        if (examinedNumber % 2 == 0) {
            return false;
        }

//skip the check for division by even numbers such as 4, 8, 10, ...
        for (int previuosNumbersIterator = 3; previuosNumbersIterator < examinedNumber; previuosNumbersIterator += 2) {
            if (examinedNumber % previuosNumbersIterator == 0) {
                return false;
            }
        }

        return true;
    }
}