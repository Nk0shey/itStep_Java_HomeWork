import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть тварину зі списку:");
        System.out.println("1 — Кіт");
        System.out.println("2 — Собака");
        System.out.println("3 — Корова");
        System.out.println("4 — Вівця");
        System.out.println("5 — Кінь");
        System.out.println("6 — Півень");
        System.out.println("7 — Порося");
        System.out.println("8 — Слон");
        System.out.println("9 — Качка");
        System.out.println("10 — Вовк");

        System.out.println("Введіть номер тварини:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Кіт: Мяу!");
                break;
            case 2:
                System.out.println("Собака: Гав!");
                break;
            case 3:
                System.out.println("Корова: Мууу!");
                break;
            case 4:
                System.out.println("Вівця: Беее!");
                break;
            case 5:
                System.out.println("Кінь: І-го-го!");
                break;
            case 6:
                System.out.println("Півень: Кукуріку!");
                break;
            case 7:
                System.out.println("Порося: Хрю!");
                break;
            case 8:
                System.out.println("Слон: Трууу!");
                break;
            case 9:
                System.out.println("Качка: Кря!");
                break;
            case 10:
                System.out.println("Вовк: Уууу!");
                break;
            default:
                System.out.println("Невірний вибір! Оберіть номер від 1 до 10.");
        }
    }
}
