package Task01and02;/*
Створіть програму, яка дозволяє ввести з клавіатури n
діапазонів цілочислових значень (наприклад, 3-10). Кожен
діапазон має початкову і кінцеву точку.Після введення, програма
має вивести довжину кожного діапазону. Програма має
виводити повідомлення про помилку, якщо початок діапазону
більший, ніж його кінець. Протестуйте звикористанням JUnit.
Приклад:
Введені дані: 3 9, -2 4, 11 15
Виведені дані: 3, 6, 4
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RangeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Range> ranges = new ArrayList<>();

        System.out.println("Введите количество диапазонов: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите начало и конец диапазона: ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            try {
                ranges.add(new Range(start, end));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Длины диапазонов:");
        for (Range range : ranges) {
            System.out.println(range.getLength());
        }

    }
}
