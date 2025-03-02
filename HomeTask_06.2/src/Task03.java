/*
Дано натуральне число N. Обчисліть суму його цифр.
Введення: 179
Виведення: 17
 */

public class Task03 {
    public static int numberSumCount(int n) {
        if (n == 0) return 0;
        return (n % 10 + numberSumCount(n / 10));
    }

    public static void main(String[] args) {
        System.out.println(numberSumCount(179));
    }
}
