package Task04;

public class MainStringMain {
    public static void main(String[] args) {
        // Тест конструктора без параметрів
        MainString emptyString = new MainString();
        System.out.println("Порожній рядок: '" + emptyString + "', Довжина: " + emptyString.getLength());

        // Тест конструктора з рядковим літералом
        MainString stringFromLiteral = new MainString("Hello, World!");
        System.out.println("Рядок: '" + stringFromLiteral + "', Довжина: " + stringFromLiteral.getLength());

        // Тест конструктора з символом
        MainString singleCharString = new MainString('A');
        System.out.println("Рядок: '" + singleCharString + "', Довжина: " + singleCharString.getLength());

        // Тест пошуку символу
        int index = stringFromLiteral.indexOf('W');
        System.out.println("Індекс символу 'W': " + index);

        // Тест пошуку символу, якого немає
        int notFoundIndex = stringFromLiteral.indexOf('Z');
        System.out.println("Індекс символу 'Z': " + notFoundIndex);

        // Тест очищення рядка
        stringFromLiteral.clear();
        System.out.println("Після очищення: '" + stringFromLiteral + "', Довжина: " + stringFromLiteral.getLength());
    }
}

