import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть шестизначне число: ");
        String number = scanner.nextLine();

        if (number.length() != 6) {
            System.out.println("Помилка: введіть шестизначне число.");
        } else {
            int firstPart = Integer.parseInt(number.substring(0, 3));
            int secondPart = Integer.parseInt(number.substring(3, 6));

            int sumFirstPart = (firstPart / 100) + ((firstPart / 10) % 10) + (firstPart % 10);
            int sumSecondPart = (secondPart / 100) + ((secondPart / 10) % 10) + (secondPart % 10);

            if (sumFirstPart == sumSecondPart) {
                System.out.println("Так");
            } else {
                System.out.println("Ні");
            }
        }
    }
}
