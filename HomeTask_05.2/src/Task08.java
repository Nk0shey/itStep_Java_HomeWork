/*
У мові Java перше слово, що входить до назви змінної,
заведено записувати з маленької латинської літери.Наступне
слово йде з великої літери (тільки перша літера слова —
велика). Слова не мають роздільників і складаються лише з
латинських літер. Наприклад, правильнізаписи змінних в Java
виглядатимуть наступним чином: javaIdentifier,
longAndMnemonicIdentifier,name, nEERC.
У мові C++, для опису змінних використовуються тільки
маленькі латинські символи і символ «_», який відокремлює
не порожні слова. Якщо рядок має змішаний синтаксис:
наприклад java_Identifier, повідомте про це. Приклади:
java_identifier, long_and_mnemonic_identifier, name, n_e_e_r_c.
Напишіть програму, яка перетворює змінну, записану однією
мовою, у формат іншої мови. Ідентифікатор (ім'я) змінної має
вводитися з клавіатури. Програма має визначити, з якої мови
взято змінну, і переробити її в змінну іншої мови. Виведіть
результат у консоль.
 */

import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ідентифікатор (ім'я) змінної: ");
        String identifier = scanner.nextLine();

        if (isJavaStyle(identifier)) {
            System.out.println("\nЦе Java-стиль. Перетворено в C++ стиль: " + toCppStyle(identifier));
        } else if (isCppStyle(identifier)) {
            System.out.println("\nЦе C++ стиль. Перетворено в Java-стиль: " + toJavaStyle(identifier));
        } else {
            System.out.println("\nІдентифікатор має змішаний або некоректний стиль.");
        }

        scanner.close();
    }
    public static boolean isJavaStyle(String identifier) {
        return identifier.matches("^[a-z]+([A-Z][a-z]*)*$");
    }

    public static boolean isCppStyle(String identifier) {
        return identifier.matches("^[a-z]+(_[a-z]+)*$");
    }

    public static String toCppStyle(String JavaIdentifier) {
        StringBuilder cppIdentifier = new StringBuilder();
        for (char character : JavaIdentifier.toCharArray()) {
            if (Character.isUpperCase(character)) {
                cppIdentifier.append('_').append(Character.toLowerCase(character));
            } else {
                cppIdentifier.append(character);
            }
        }
        return cppIdentifier.toString();


    }

    public static String toJavaStyle(String cppIdentifier) {
        StringBuilder javaIdentifier = new StringBuilder();
        boolean nextUpperCase = false;

        for (char character : cppIdentifier.toCharArray()) {
            if (character == '_') {
                nextUpperCase = true;
            } else if (nextUpperCase) {
                javaIdentifier.append(Character.toUpperCase(character));
            } else {
                javaIdentifier.append(character);
            }
        }
        return javaIdentifier.toString();
    }
}
