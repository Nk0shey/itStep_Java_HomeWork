import java.util.Scanner;
/*
Обчисліть суму чисел від 1 до n, які діляться на 3.**
- Вхідні дані: `int n`.*
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число n");
        int n = scanner.nextInt();

        int result = 0;

        for (int i = 1; i <= n; i++) {
           if (i % 3 == 0) {
               result = result + i;
           }
        }
        System.out.println("N дорівнює: " + n + " Результат: " + result);
    }
}