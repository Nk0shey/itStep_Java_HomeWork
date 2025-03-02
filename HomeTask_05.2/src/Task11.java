/*
Слова мовою Мумба-Юмба можуть складатися лише з літер a,
b, c, і при цьому:
 ніколи не мати двох літер b поспіль;
 ні в одному слові ніколи не зустрічаються три однакових
підслів поспіль. Наприклад, за таким правилом, до мові
Мумба-Юмба не може входити слова aaa (оскільки три рази
поспіль містить підслово a), ababab (оскільки три рази
поспіль містить підслово ab), aabcabcabca (три рази поспіль
містить підслово abc).
Усі слова, які відповідають вищеописаним правилам, входять
до мови Мумба-Юмба.
Напишіть програму, яка за поданим словом (введеного з
клавіатури) визначить, чи належить воно до цієї мови.
 */

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть слово: ");
        String word = scanner.nextLine();

        if (isMumboYumba(word)) {
            System.out.println("Слово належить мові Мумба-Юмба.");
        } else {
            System.out.println("Слово не належить мові Мумба-Юмба.");
        }

        scanner.close();
    }

    public static boolean isMumboYumba(String word) {
        if (word.contains("bb")) {
            return false;
        }

        for (int length = 1; length <= word.length() / 3; length++) {
            for (int i = 0; i <= word.length() - 3 * length; i++) {
                String part = word.substring(i, i + length);
                if (word.startsWith(part, i + length) && word.startsWith(part, i + 2 * length)) {
                    return false;
                }
            }
        }

        return true;
    }
}