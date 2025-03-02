/*
Створіть клас Money (Гроші) для роботи з грошовими сумами.
Число має бути представлене двома полями:
 типу long – для гривень;
 типу byte – для копійок.
Реалізуйте виведення значення на екран, при цьому дробова
частина має бути відокремлена комою від цілої частини.
Реалізуйте додавання, віднімання, ділення сум, ділення сумина
дробове число, множення на дробове число та операції
порівняння. Протестуйте з використанням JUnit.
 */

package Task03;

import java.util.Scanner;

public class MoneyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть першу суму (гривні і копійки):");
        long hryvnias1 = scanner.nextLong();
        byte kopecks1 = scanner.nextByte();

        System.out.println("Введіть другу суму (гривні і копійки):");
        long hryvnias2 = scanner.nextLong();
        byte kopecks2 = scanner.nextByte();

        MoneyEngine money1 = new MoneyEngine(hryvnias1, kopecks1);
        MoneyEngine money2 = new MoneyEngine(hryvnias2, kopecks2);

        System.out.println("Перша сума: " + money1);
        System.out.println("Друга сума: " + money2);

        System.out.println("Сума: " + money1.add(money2));
        System.out.println("Різниця: " + money1.subtract(money2));
        System.out.println("Множення першої суми на 2.5: " + money1.multiply(2.5));
        System.out.println("Ділення першої суми на 3: " + money1.divide(3));

        System.out.println("Чи більша перша сума за другу? " + money1.isGreaterThan(money2));
        System.out.println("Чи рівні суми? " + money1.isEqualTo(money2));
    }
}

