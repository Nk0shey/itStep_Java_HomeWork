import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть Ваш час (від 0 до 24 години, також можете ввести у точності до хвилин, через крапку, наприклад: 12.15): ");
        double hour = scanner.nextDouble();

        if (hour < 0 || hour > 24) {
            System.out.println("Неправильний формат часу! Введіть значення від 0 до 24.");
        } else if (hour >= 5 && hour < 12) {
            System.out.println("Доброго ранку!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Доброго дня!");
        } else if (hour >= 18 && hour < 22) {
            System.out.println("Доброго вечора!");
        } else {
            System.out.println("Доброї ночі!");
        }
    }
}
