/*
Самозакохане число, або число Армстронга — натуральне число,
яке дорівнює сумі своїх цифр, піднесених до степеня, що дорівнює
кількості його цифр.
Виведіть на екран всі числа Армстронга в діапазоні від 10 до
1 000 000.
 */

public class Task03 {
    public static void main(String[] args) {
        int lowerLimit = 10;
        int upperLimit = 1000000;

        System.out.println("Числа Армстронга в діапазоні від " + lowerLimit + " до " + upperLimit + ":");

        for (int number = lowerLimit; number <= upperLimit; number++) {
            if (isArmstrongNumber(number)) {
                System.out.println(number);
            }
        }
    }

    public static boolean isArmstrongNumber(int number) {
        String numberStr = Integer.toString(number);
        int length = numberStr.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(numberStr.charAt(i));
            sum += Math.pow(digit, length);
        }

        return sum == number;
    }
}


