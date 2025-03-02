package Task03.NumberSet;

/*
Створіть клас з набором цілих чисел. Реалізуйте клас з такою
функціональністю:
 Сума елементів набору.
 Середнє арифметичне елементів набору.
 Максимум з елементів набору.
 Мінімум з елементів набору.
Протестуйте всі можливості створеного класу з використанням
JUnit.
 */

import java.util.List;

public class NumberSet {
    private final List<Integer> numbers;

    public NumberSet(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public double average() {
        return numbers.isEmpty() ? 0 : sum() / (double) numbers.size();
    }

    public int max() {
        return numbers.stream().max(Integer::compare).orElseThrow();
    }

    public int min() {
        return numbers.stream().min(Integer::compare).orElseThrow();
    }
}
