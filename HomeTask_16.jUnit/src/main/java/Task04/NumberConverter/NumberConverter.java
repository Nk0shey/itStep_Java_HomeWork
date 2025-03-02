package Task04.NumberConverter;

/*
Створіть клас для числа. Реалізуйте клас з такою
функціональністю:
 Запис та читання значення.
 Переведення числа у вісімкову систему числення.
 Переведення числа у шістнадцяткову систему числення.
 Переведення числа у двійкову систему числення.
Протестуйте всі можливості створеного класу з використанням
JUnit.
 */

public class NumberConverter {
    private final int number;

    public NumberConverter(int number) {
        this.number = number;
    }

    public String toBinary() {
        return Integer.toBinaryString(number);
    }

    public String toOctal() {
        return Integer.toOctalString(number);
    }

    public String toHexadecimal() {
        return Integer.toHexString(number);
    }

    public int getValue() {
        return number;
    }
}
