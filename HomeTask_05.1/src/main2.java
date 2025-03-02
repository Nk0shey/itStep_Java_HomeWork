/*
- Подсчитайте количество 1-битов в числе.
 */

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число, которое хотите перевести в двоичную систему: ");
        int n = scanner.nextInt();

//        System.out.println("Число в двоичной системе: " + String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'));
//        System.out.println("число в двоичной системе: " + Integer.toBinaryString(n));

        int oneBitCount = Integer.bitCount(n);
        System.out.println("Количество 1-битов: " + oneBitCount);

        int totalBits = 32;
        int zeroBitCount = totalBits - oneBitCount;
        System.out.println("Количество 0-х битов: " + zeroBitCount);
    }
}
