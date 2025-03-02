/*
Дано натуральне число N. Виведіть слово YES, якщо число N є
точним степенем двійки, або слово NO — якщо ні.
Операціє піднесення до степеня не користуватися!
Введення: 3 8
Виведення: NO YES
 */

public class Task02 {
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n == 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3) ? "Yes" : "No");
        System.out.println(isPowerOfTwo(8) ? "Yes" : "No");
    }
}
