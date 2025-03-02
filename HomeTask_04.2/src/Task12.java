/*
У перший день спортсмен пробіг x кілометрів, а потім він щодня
збільшував пробіг на 10% від попередньогозначення. За числом
y, вказаним з клавіатури, визначте номер дня, в який пробіг
спортсмена складатиме не менше y кілометрів.
 */

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть пробіг у перший день (км): ");
        double x = scanner.nextDouble();

        System.out.print("Введіть значення y (км): ");
        double y = scanner.nextDouble();

        int day = 1;
        double distance = x;

        while (distance < y) {
            distance += distance * 0.10;
            day++;
        }
        System.out.println("На " + day + " день пробіг спортсмена складе не менше " + y + " км.");
    }
}
