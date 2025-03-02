/*
Введіть рядок тексту з клавіатури, а потім один символ.Покажіть
в консолі індекси і кількість збігів (шукаємо входження символу
в рядок). Якщо збігів не знайдено, виведіть відповідний текст.
 */

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок: ");
        String text = scanner.nextLine();

        System.out.print("Введіть символ для пошуку: ");
        char symbol = scanner.next().charAt(0);

        int count = 0;

        System.out.println("Індекси входжень символу '" + symbol + "':");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == symbol) {
                System.out.print(i + " ");
                count++;
            }
        }

        if (count > 0) {
            System.out.println("\nКількість збігів: " + count);
        } else {
            System.out.println("Збігів не знайдено.");
        }

        scanner.close();
    }
}
