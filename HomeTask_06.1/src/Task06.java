/*
Напишіть метод, який перевіряє правильність розстановки дужок у рядку, введеному
з клавіатури. При правильній розстановці дужок виконуються умови:
 однакова кількість відкриваючих і закриваючих дужок;
 всередині будь-якої пари: відкриваюча дужка і відповідна їй закриваюча
дужка, вважаються розставленими правильно.
В рядку можуть бути як круглі, так і квадратні дужки (та ін. символи). Кожній
відкриваючій дужці відповідає закриваюча дужка того ж типу (для круглої —кругла, для
квадратної — квадратна).
Приклад неправильного розташування: ( [ a) b]
Приклад правильно введених даних: (a[b](f[(g)(g)]))
Програма має вивести результат у вигляді повідомлення.Приклади:
 Правильний рядок.
 Помилка: відсутність (
 Помилка: відсутність )
 Помилка: відсутність [
 Помилка: відсутність ]
 */

import java.util.Scanner;
import java.util.Stack;

public class Task06 {
    public static void main(String[] args) {

        // Введення рядка з клавіатури
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок: ");
        String input = scanner.nextLine();

        checkParentheses(input);
    }

    private static void checkParentheses(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Якщо це відкрита кругла дужка, додаємо в стек
            if (currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
            }

            // Якщо це закрита кругла або квадратна дужка
            else if (currentChar == ')' || currentChar == ']') {
                // Якщо стек порожній або тип дужок не співпадає
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), currentChar)) {
                    System.out.println("Помилка: неправильна розстановка дужок.");
                    return;
                }
                // Відкриваємо пару дужок
                stack.pop();
            }
        }

        // Якщо після проходу рядка в стеку залишаються елементи
        if (!stack.isEmpty()) {
            char unclosed = stack.peek();
            if (unclosed == '(') {
                System.out.println("Помилка: відсутність )");
            } else if (unclosed == '[') {
                System.out.println("Помилка: відсутність ]");
            }
        } else {
            System.out.println("Правильний рядок.");
        }
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') || (opening == '[' && closing == ']');
    }
}
