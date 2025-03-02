/*
Обчисліть суму чисел певного діапазону. Початок і кінець
діапазону задається параметрами.
Введення: 5 9
Виведення: 35
 */

public class Task09 {
    public static int sumInRange(int A, int B) {
        if (A > B) return 0;
        return A + sumInRange(A + 1, B);
    }

    public static void main(String[] args) {
        System.out.println(sumInRange(5, 9));
    }
}
