/*
Напишіть програму, яка зчитуватиме з консолі будь-яке
число (від 0 до 99999999) і виводитиме його цифри у вигляді
символів «*» (див. рис.).
Приклад для числа 41072819:
 */

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число (від 0 до 99999999): ");
        String number = scanner.nextLine();

        if (!number.matches("\\d{1,8}")) {
            System.out.println("Будь ласка, введіть число в діапазоні від 0 до 99999999.");
            scanner.close();
            return;
        }

        String[] lines = new String[5];

        for (int i = 0; i < lines.length; i++) {
            lines[i] = "";
        }

        for (char digit : number.toCharArray()) {
            switch (digit) {
                case '0':
                    lines[0] += " *** ";
                    lines[1] += "*   *";
                    lines[2] += "*   *";
                    lines[3] += "*   *";
                    lines[4] += " *** ";
                    break;
                case '1':
                    lines[0] += "  *  ";
                    lines[1] += " **  ";
                    lines[2] += "  *  ";
                    lines[3] += "  *  ";
                    lines[4] += " *****";
                    break;
                case '2':
                    lines[0] += " *** ";
                    lines[1] += "    *";
                    lines[2] += "   * ";
                    lines[3] += "  *  ";
                    lines[4] += "*****";
                    break;
                case '3':
                    lines[0] += " *** ";
                    lines[1] += "    *";
                    lines[2] += "  ** ";
                    lines[3] += "    *";
                    lines[4] += " *** ";
                    break;
                case '4':
                    lines[0] += "*   *";
                    lines[1] += "*   *";
                    lines[2] += " *****";
                    lines[3] += "    *";
                    lines[4] += "    *";
                    break;
                case '5':
                    lines[0] += "*****";
                    lines[1] += "*    ";
                    lines[2] += "*****";
                    lines[3] += "    *";
                    lines[4] += " *** ";
                    break;
                case '6':
                    lines[0] += " *** ";
                    lines[1] += "*    ";
                    lines[2] += "*****";
                    lines[3] += "*   *";
                    lines[4] += " *** ";
                    break;
                case '7':
                    lines[0] += "*****";
                    lines[1] += "    *";
                    lines[2] += "   * ";
                    lines[3] += "  *  ";
                    lines[4] += " *   ";
                    break;
                case '8':
                    lines[0] += " *** ";
                    lines[1] += "*   *";
                    lines[2] += " *****";
                    lines[3] += "*   *";
                    lines[4] += " *** ";
                    break;
                case '9':
                    lines[0] += " *** ";
                    lines[1] += "*   *";
                    lines[2] += " *****";
                    lines[3] += "    *";
                    lines[4] += " *** ";
                    break;
                default:
                    break;
            }

            for (int i = 0; i < lines.length; i++) {
                lines[i] += "   ";
            }
        }

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
