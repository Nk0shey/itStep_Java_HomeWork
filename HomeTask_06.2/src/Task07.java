/*
Дано речення, складене лише з малих латинських літер.
Перевірте, чи усі слова в реченні є паліндромами. Виведіть YES
або NO.
Введення: radar yes
Виведення: YES NO
 */

public class Task07 {
    public static void checkAllWords(String sentence) {
        int spaceIndex = sentence.indexOf(' ');
        if (spaceIndex == -1) {
            System.out.print(isPalindromeWord(sentence, 0, sentence.length() - 1) ? "YES" : "NO");
            return;
        }

        String firstWord = sentence.substring(0, spaceIndex);
        String remaining = sentence.substring(spaceIndex + 1);

        System.out.print(isPalindromeWord(firstWord, 0, firstWord.length() - 1) ? "YES " : "NO ");
        checkAllWords(remaining);
    }

    public static boolean isPalindromeWord(String word, int left, int right) {
        if (left >= right) return true; // Базовый случай: дошли до середины слова
        if (word.charAt(left) != word.charAt(right)) return false; // Если символы не совпадают
        return isPalindromeWord(word, left + 1, right - 1); // Рекурсивно проверяем внутренние символы
    }

    public static void main(String[] args) {
        checkAllWords("radar yes");
        System.out.println();
    }
}
