import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть номер дня тижня: ");
        int daOfTheWeek = sc.nextInt();
        switch (daOfTheWeek) {
            case 1:
                System.out.println("Ви ввели перший день тижня - тобто Понеділок");
            break;
            case 2:
                System.out.println("Ви ввели другий день тижня - тобто Вівторок");
            break;
            case 3:
                System.out.println("Ви ввели третій день тижня - тобто Середу");
            break;
            case 4:
                System.out.println("Ви ввели четвертий день тижня - тобто Четвер");
            break;
            case 5:
                System.out.println("Ви ввели пʼятий день тижня - тобто Пʼятницю");
            break;
            case 6:
                System.out.println("Ви ввели шостий день тижня - тобто Суботу");
            break;
            case 7:
                System.out.println("Ви ввели сьомий день тижня - тобто Неділю");
            break;
            default:
                System.out.println("Ви ввели не існуючий день тижня, введіть число від 1 до 7 щоб отримати правильну відповідь.");
        }
    }
}
