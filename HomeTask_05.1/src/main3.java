/*
Завдання 4: Користувач вводить з клавіатури два числа. Розрахуйте суму чисел у вказаному діапазоні,
а також середнє арифметичне.
*/
import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите число A: ");
        int a = sc.nextInt();
        System.out.println("Введите число B: ");
        int b = sc.nextInt();

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        System.out.println("Початок діапазону: " + start);
        System.out.println("Кінець діапазону: " + end);

        int sum = 0;
        int numberAmount = 0;
        for (int i = start; i <= end; i++) {
            sum = sum + i;
            System.out.println("Sum in loop: " + sum);
            System.out.println("I in loop: " + i);
            numberAmount++;
        }

        System.out.println("number amount: " + numberAmount);

        float average = (float)sum / numberAmount;

        System.out.println("Сума чисел усього діапазону: " + sum);
        System.out.println("Середнє арифметичне двох вводних чисел: " + average);
    }
}
