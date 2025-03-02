/*
Опишіть базовий клас MainString (Рядок). Обов'язкові поля
класу:
 масив символів;
 значення типу int зберігає довжину рядка у символах.
Реалізуйте обов'язкові методи наступного призначення:
 конструктор без параметрів;
 конструктор, який приймає рядковий літерал як параметр;
 конструктор, який приймає символ як параметр;
 метод отримання довжини рядка;
 метод очищення рядка (робить рядок порожнім);
 метод пошуку символу в рядку.
 */

package Task04;

public class MainString {

    private char[] characters;
    private int length;

    public MainString() {
        this.characters = new char[0];
        this.length = 0;
    }

    public MainString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Рядок не може бути null");
        }
        this.characters = str.toCharArray();
        this.length = characters.length;
    }

    public MainString(char ch) {
        this.characters = new char[]{ch};
        this.length = 1;
    }

    public int getLength() {
        return this.length;
    }

    public void clear() {
        this.characters = new char[0];
        this.length = 0;
    }

    public int indexOf(char ch) {
        for (int i = 0; i < this.length; i++) {
            if (this.characters[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return new String(characters);
    }
}
