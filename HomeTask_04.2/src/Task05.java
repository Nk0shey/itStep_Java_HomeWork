/*
Напишіть програму, яка перевірятиме, чи є введене число з
клавіатури, паліндромом (яке можна однаковопрочитати в обох
напрямках). Наприклад, 123454321 або 221122 — паліндром.
Програма має вивести YES, якщо число є паліндромом, і NO якщо
число не паліндром
 */

import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number N: ");
        int originalNumber = scanner.nextInt();
        int number = originalNumber;
        int reversedNumber = 0;
        int counter = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;

            System.out.println("counter: " + counter);
            System.out.println("number: " + number);
            System.out.println("reversed number: " + reversedNumber);
            System.out.println("digit: " + digit);

            counter++;
        }

        System.out.println("Реверсированное число: " + reversedNumber);
        System.out.println("ORIGINAL NUMBER: " + originalNumber);

        if (reversedNumber == originalNumber) {
            System.out.println("Palindrome number");
        } else {
            System.out.println("Not palindrome number");
        }
    }
}