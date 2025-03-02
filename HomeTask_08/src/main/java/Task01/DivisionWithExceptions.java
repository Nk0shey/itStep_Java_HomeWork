/*
Створіть метод, який виводить у консоль результат
цілочислового поділу числа, введеного з клавіатури, на
значення елементів одновимірного масиву цілих чисел,
заповнених випадковим чином — від -10 до 10. Довжина масиву
випадкова — від 1 до 10.
Обробіть всі можливі виняткові ситуації в даному методі.
 */

package Task01;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DivisionWithExceptions {
    public static void main(String[] args) {
        handleDivision();
    }

    private static void handleDivision() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        try {
            // Генерація випадкової довжини масиву (від 1 до 10)
            int arrayLength = random.nextInt(10) + 1;

            // Створення масиву та його заповнення випадковими числами від -10 до 10
            int[] numbers = new int[arrayLength];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = random.nextInt(21) - 10; // Від -10 до 10
            }

            // Введення числа з клавіатури
            System.out.print("Введіть ціле число: ");
            int inputNumber = scanner.nextInt();

            System.out.println("Результати ділення:");
            for (int i = 0; i < numbers.length; i++) {
                try {
                    System.out.printf("%d / %d = %d\n", inputNumber, numbers[i], inputNumber / numbers[i]);
                } catch (ArithmeticException e) {
                    System.out.printf("%d / %d = Division by zero (на 0 ділити не можна)\n", inputNumber, numbers[i]);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Помилка: введено некоректне число. Переконайтеся, що ви вводите ціле число.");
        } catch (Exception e) {
            System.out.println("Несподівана помилка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Програма завершила роботу.");
        }
    }
}
