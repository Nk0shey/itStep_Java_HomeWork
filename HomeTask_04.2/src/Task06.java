/*
Вивести у консоль усі восьмизначні числа, цифри в яких не
повторюються. Ці числа мають ділитися на 12345 без остачі.
Покажіть загальну кількість знайдених чисел.
 */

public class Task06 {
    public static void main(String[] args) {
        int count = 0;
        for (int number = 10000000; number <= 99999999; number++) {
            if (number % 12345 == 0 && hasUniqueDigits(number)) {
                System.out.println(number);
                count++;
            }
        }
        System.out.println("Загальна кількість знайдених чисел: " + count);
    }

    public static boolean hasUniqueDigits(int number) {
        boolean[] digits = new boolean[10];

        while (number > 0) {
            int digit = number % 10;
            if (digits[digit]) {
                return false;
            }
            digits[digit] = true;
            number /= 10;
        }
        return true;
    }
}
