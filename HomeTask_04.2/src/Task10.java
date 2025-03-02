/*
2520 — найменше число, яке можна поділити на кожне із чисел
від 1 до 10, без залишку. Напишіть програму, яка обчислює
найменше додатне число, яке поділяється на всі числа від 1 до
20.
 */

public class Task10 {
    // Метод для нахождения НДК
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для нахождения НОК
    public static long lcm(int a, int b) {
        return (long) a * (b / gcd(a, b)); // Убедитесь, что используете long
    }

    public static void main(String[] args) {
        long lcmValue = 1; // Используем long для предотвращения переполнения

        for (int i = 2; i <= 20; i++) {
            lcmValue = lcm((int) lcmValue, i);
        }

        System.out.println("Найменше число, яке ділиться на всі числа від 1 до 20: " + lcmValue);
    }
}
