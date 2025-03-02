/*
Електронний годинник показує час у форматі від 00:00 до 23:59.
Напишіть програму, яка виведе в консоль, скільки разів на добу
трапляється симетрична комбінація цифр на годиннику
(наприклад: 02:20, 11:11 або 15:51). Виведіть на екран всі
симетричні комбінації. Виведіть загальне число комбінацій.
 */

public class Task08 {
    public static void main(String[] args) {
        int count = 0;

        System.out.println("Симетричні комбінації: ");

        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute <= 60; minute++) {
                int firstHourDigit = hour / 10;
                int secondHourDigit = hour % 10;
                int firstMinuteDigit = minute / 10;
                int secondMinuteDigit = minute % 10;

                if (firstHourDigit == secondMinuteDigit && secondHourDigit == firstMinuteDigit) {
                    System.out.printf("%02d:%02d\n", hour, minute);
                    count++;
                }
            }
        }
        System.out.println("Загальна кількість симетричних комбінацій: " + count);
    }
}
