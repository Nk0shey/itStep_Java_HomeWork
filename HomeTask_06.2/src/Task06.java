/*
Введіть з клавіатури число n, десятковий запис якого не
містить нулів. Отримайте число, записане тими ж цифрами, але
у зворотному порядку. При вирішенні цього завдання
дозволяється лише рекурсія та цілочислова арифметика.
має повертати ціле число, яке є результатом роботи програми;
виводити число по одній цифрі не можна.
Введення: 179
Виведення: 971
 */

public class Task06 {
    public static int reverseNumber(int n, int reversed) {
        if (n == 0) return reversed;
        return reverseNumber(n / 10, reversed * 10 + n % 10);
    }

    public static int reverseNumber(int n) {
        return reverseNumber(n, 0);
    }

    public static void main(String[] args) {
        System.out.println(reverseNumber(179));
    }
}
