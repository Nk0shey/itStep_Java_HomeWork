/*
Створіть метод, який приймає на вхід число. В разі, якщо
число від'ємне, у методі має бути виняток, що перевіряється.
Якщо число більше 100, має бути неперевірений виняток.
Створіть свої винятки для даного прикладу.
Протестуйте метод з допомогою JUnit-тестів
 */

package Task02;

// Власний перевіряємий виняток для від'ємних чисел
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

// Власний неперевірений виняток для чисел більше 100
class NumberTooLargeException extends RuntimeException {
    public NumberTooLargeException(String message) {
        super(message);
    }
}

public class NumberProcessor {
    public void processNumber(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("Число від'ємне: " + number);
        } if (number > 100) {
            throw new NumberTooLargeException("Число більше 100: " + number);
        }
        System.out.println("Число коректне: " + number);
    }
}
