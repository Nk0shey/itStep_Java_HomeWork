import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть один символ: ");
        char inputChar = scanner.nextLine().charAt(0);

        if (Character.isDigit(inputChar)) {
            System.out.println("Цифра");
        }

        else if (Character.isLetter(inputChar)) {

            Character.UnicodeBlock block = Character.UnicodeBlock.of(inputChar);

            if (block == Character.UnicodeBlock.BASIC_LATIN) {
                System.out.println("Латиниця");
            } else if (block == Character.UnicodeBlock.CYRILLIC) {
                System.out.println("Кирилиця");
            } else {
                System.out.println("Неможливо визначити");
            }

        }

        else {
            System.out.println("неможливо визначити");
        }
    }
}
