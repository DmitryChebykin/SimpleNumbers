import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите положительное целое число !=0 (например 1 или 15589) :");
        int examinedNumber = scanner.nextInt();

        System.out.println("Введите количество простых чисел в выводимой строке.");
        System.out.println("Наиболее наглядно сделать количество от 5 до 35 : ");
        int lineNumbersQuantity = scanner.nextInt();

        printPrimeNumbers(examinedNumber, lineNumbersQuantity);
    }

    private static void printPrimeNumbers(int examinedNumber, int lineNumbersQuantity) {
        int printedNumbersQuantity = 1;
        int primeNumbersQuantity = 0;

        for (int i = 1; i <= examinedNumber; i++) {
            if (isPrime(i)) {
                primeNumbersQuantity++;
                printedNumbersQuantity++;
                System.out.print(i + ", ");

                if (printedNumbersQuantity % lineNumbersQuantity == 0) {
                    System.out.println();
                }
            }
        }

        System.out.printf("%nКоличество найденных простых чисел равно %d.%n", primeNumbersQuantity);
    }

    private static boolean isPrime(int examinedNumber) {
        if (examinedNumber <= 3) {
            return (examinedNumber > 1);
        }

        if (examinedNumber % 2 == 0) {
            return false;
        }

        // skip the check for division by even numbers such as 4, 8, 10, ...
        for (int i = 3; i < examinedNumber; i += 2) {
            if (examinedNumber % i == 0) {
                return false;
            }
        }

        return true;
    }
}