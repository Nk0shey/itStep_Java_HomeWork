import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        final double milkPerStudent = 0.2;
        final double milkPackageVolume = 0.9;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть загальну кількість учнів: ");
        int studentNum = scanner.nextInt();

        System.out.println("Введіть кількість учнів (у відсотках), вага яких менша за 30 кілограм: ");
        int studentWeightPercentage = scanner.nextInt();

        if (studentWeightPercentage != 100 && studentWeightPercentage != 60 && studentWeightPercentage != 1) {
            System.out.println("Ви ввели не допустиму кількість у відсотках. Можна ввести тільки: 100, 60 або 1.");
            return;
        }

        int studentsUnder30Kg = (studentNum * studentWeightPercentage) / 100;
        int studentsOver30Kg = studentNum - studentsUnder30Kg;

        int totalPies = studentsOver30Kg + (studentsUnder30Kg * 2);

        double totalMilkLiters = studentsUnder30Kg * milkPerStudent;
        int totalMilkPackages = (int) Math.ceil(totalMilkLiters / milkPackageVolume);

        System.out.println("Загальна кількість пиріжків: " + totalPies);
        System.out.println("Загальна кількість пакетів молока: " + totalMilkPackages);
        }
    }

